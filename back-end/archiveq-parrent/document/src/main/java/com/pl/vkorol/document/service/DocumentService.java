package com.pl.vkorol.document.service;

import com.pl.vkorol.document.model.SearchDocumentInstanceQuery;
import com.pl.vkorol.document.model.entity.ArchiveDocument;
import com.pl.vkorol.document.model.entity.DocumentInstance;
import com.pl.vkorol.document.model.payload.response.DocumentInstanceDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface DocumentService {

    void createArchiveDocument(ArchiveDocument archiveDocument);
    List<ArchiveDocument> getAllDocuments();
    List<ArchiveDocument> getAllDocuments(int page, int pageSize);
    ArchiveDocument getDocumentByName(String name);
    void createDocument(DocumentInstance documentInstance);
    List<DocumentInstance> searchDocumentInstanceByQuery(SearchDocumentInstanceQuery query);
    Optional<DocumentInstance> getDocumentById(String documentUuid);
}
