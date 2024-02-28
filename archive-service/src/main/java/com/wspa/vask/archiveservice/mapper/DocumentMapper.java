package com.wspa.vask.archiveservice.mapper;

import com.wspa.vask.archiveservice.kafka.DocumentMessage;
import com.wspa.vask.archiveservice.document.model.DescriptorImpl;
import com.wspa.vask.archiveservice.document.model.Document;
import com.wspa.vask.archiveservice.document.model.DocumentImpl;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DocumentMapper {

    public DocumentImpl documentMessageToDocument(DocumentMessage documentMessage) {
        return null;
    }
}
