package com.wspa.vask.archiveservice.kafka;

import com.wspa.vask.archiveservice.document.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;

public class KafkaListener {

    @Autowired
    private DocumentService documentService;

    void listen(DocumentMessage documentMessage) {
        documentService.addDocument(documentMessage);

    }
}
