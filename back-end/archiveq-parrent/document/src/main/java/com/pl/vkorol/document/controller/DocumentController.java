package com.pl.vkorol.document.controller;

import com.pl.vkorol.document.kafka.KafkaMessage;
import com.pl.vkorol.document.mapper.DocumentInstanceMapper;
import com.pl.vkorol.document.model.SearchDocumentInstanceQuery;
import com.pl.vkorol.document.model.entity.DocumentInstance;
import com.pl.vkorol.document.model.payload.DocumentDto;
import com.pl.vkorol.document.service.DocumentService;
import com.pl.vkorol.document.service.FileService;
import com.pl.vkorol.document.service.TransformService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/document")
@RequiredArgsConstructor
@Slf4j
public class DocumentController {

    private final DocumentService documentService;
    private final TransformService transformService;
    private final DocumentInstanceMapper documentInstanceMapper;
    private final FileService fileService;

    @PostMapping(value = "/create")
    public ResponseEntity<?> createDocument(@RequestBody DocumentDto documentDto) {
        try {
            DocumentInstance documentInstance = transformService.toDocumentInstance(documentDto);
            documentService.createDocument(documentInstance);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Archive document already exists");
        }
        return ResponseEntity.ok("Successfully created new archive document");
    }

    @PostMapping(value = "/search")
    public ResponseEntity<?> getDocumentsByQuery(@RequestBody DocumentDto documentDto) {
        try {
            List<DocumentInstance> documentInstances =
                    documentService.searchDocumentInstanceByQuery(SearchDocumentInstanceQuery.ofDocumentDto(documentDto));
            return ResponseEntity.ok(documentInstanceMapper.documentInstanceListToDocumentInstanceDtoList(documentInstances));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Archive document already exists");
        }
    }

    @GetMapping("/search/{uuid}")
    public ResponseEntity<?> getDocumentById(@PathVariable("uuid") String documentUuid) {
        return documentService.getDocumentById(documentUuid)
                .map(body -> ResponseEntity.ok().body(documentInstanceMapper.documentInstanceToDocumentInstanceDto(body)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(value = "/upload/{uuid}")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file, @PathVariable("uuid") String documentUuid) {
        byte[] bytes = new byte[0];
        try {
            bytes = file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        KafkaMessage kafkaMessage = KafkaMessage.builder()
                .content(bytes)
                .fileName(file.getOriginalFilename())
                .documentUuid(documentUuid)
                .build();
        fileService.sendFile(kafkaMessage);
        return ResponseEntity.ok().build();
    }
}
