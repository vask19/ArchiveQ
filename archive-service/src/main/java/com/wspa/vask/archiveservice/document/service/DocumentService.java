package com.wspa.vask.archiveservice.document.service;

import com.wspa.vask.archiveservice.kafka.DocumentMessage;
import com.wspa.vask.archiveservice.document.model.Document;

public interface DocumentService {

    void addDocument(DocumentMessage documentMessage);
    Document getDocument(String documentId);


}
