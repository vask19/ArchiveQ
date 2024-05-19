package com.pl.vkorol.document.controller;

import com.pl.vkorol.document.mapper.ArchiveDocumentMapper;
import com.pl.vkorol.document.model.entity.ArchiveDocument;
import com.pl.vkorol.document.model.payload.request.ArchiveDocumentDto;
import com.pl.vkorol.document.model.payload.request.PostArchiveDocument;
import com.pl.vkorol.document.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/v1/document/archive")
@RequiredArgsConstructor
public class ArchiveDocumentController {

    private final ArchiveDocumentMapper archiveDocumentMapper;
    private final DocumentService documentService;

    @PostMapping
    public ResponseEntity<?> createArchiveDocument(@RequestBody PostArchiveDocument postArchiveDocument) {
        try {
            ArchiveDocument archiveDocument = archiveDocumentMapper.postArchiveDocumentToArchiveDocument(postArchiveDocument);
            documentService.createArchiveDocument(archiveDocument);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Archive document already exists");
        }
        return ResponseEntity.ok("Successfully created new archive document");
    }

    @GetMapping
    @RequestMapping(value = "/all")
    public ResponseEntity<List<ArchiveDocumentDto>> getArchiveDocuments() {
        List<ArchiveDocumentDto> archiveDocumentDtos = documentService.getAllDocuments()
                .stream()
                .map(archiveDocumentMapper::archiveDocumentToArchiveDocumentDto).toList();
        return ResponseEntity.ok(archiveDocumentDtos);
    }

    @GetMapping
    public ResponseEntity<List<ArchiveDocumentDto>> getArchiveDocuments(@RequestParam(required = false, defaultValue = "1") int _page,
                                                                        @RequestParam(required = false, defaultValue = "10") int _pageSize) {
        List<ArchiveDocumentDto> archiveDocumentDtos = documentService.getAllDocuments(_page, _pageSize)
                .stream()
                .map(archiveDocumentMapper::archiveDocumentToArchiveDocumentDto).toList();
        return ResponseEntity.ok(archiveDocumentDtos);
    }

    @RequestMapping(method = RequestMethod.GET, value = "{name}")
    public ResponseEntity<ArchiveDocumentDto> getArchiveDocumentByName(@PathVariable String name) {
        ArchiveDocumentDto documentByName = archiveDocumentMapper.archiveDocumentToArchiveDocumentDto(documentService.getDocumentByName(name));
        return ResponseEntity.ok(documentByName);
    }
}
