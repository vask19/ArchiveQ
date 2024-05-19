package com.pl.vkorol.document.controller;

import com.pl.vkorol.document.model.entity.ArchiveDocument;
import com.pl.vkorol.document.model.entity.DocumentInstance;
import com.pl.vkorol.document.model.payload.DocumentDto;
import com.pl.vkorol.document.service.DocumentService;
import com.pl.vkorol.document.service.TransformService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/document")
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentService documentService;
    private final TransformService transformService;

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
}
