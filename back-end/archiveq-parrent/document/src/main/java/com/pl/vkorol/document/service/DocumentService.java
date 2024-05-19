package com.pl.vkorol.document.service;

import com.pl.vkorol.document.model.entity.ArchiveDocument;
import com.pl.vkorol.document.model.entity.DocumentInstance;

import java.util.List;

public interface DocumentService {

    void createArchiveDocument(ArchiveDocument archiveDocument);
    List<ArchiveDocument> getAllDocuments();
    List<ArchiveDocument> getAllDocuments(int page, int pageSize);
    ArchiveDocument getDocumentByName(String name);
    void createDocument(DocumentInstance documentInstance);
}
