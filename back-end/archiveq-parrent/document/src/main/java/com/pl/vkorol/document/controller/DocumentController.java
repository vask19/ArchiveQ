package com.pl.vkorol.document.controller;

import com.pl.vkorol.document.mapper.DocumentInstanceMapper;
import com.pl.vkorol.document.model.SearchDocumentInstanceQuery;
import com.pl.vkorol.document.model.entity.ArchiveDocument;
import com.pl.vkorol.document.model.entity.DocumentInstance;
import com.pl.vkorol.document.model.payload.DocumentDto;
import com.pl.vkorol.document.model.payload.response.DocumentInstanceDto;
import com.pl.vkorol.document.service.DocumentService;
import com.pl.vkorol.document.service.TransformService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/document")
@RequiredArgsConstructor
@Slf4j
public class DocumentController {

    private final DocumentService documentService;
    private final TransformService transformService;
    private final DocumentInstanceMapper documentInstanceMapper;

    @PostMapping(value = "/create")
    public ResponseEntity<?> createArchiveDocument(@RequestBody DocumentDto documentDto) {
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
            return ResponseEntity.ok(documentInstanceMapper.documentInstanceListDoDocumentInstanceDtoList(documentInstances));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Archive document already exists");
        }
    }
}
