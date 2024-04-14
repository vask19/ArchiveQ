package com.wspa.vask.archiveservice.document.repository;

import com.wspa.vask.archiveservice.document.model.DescriptorImpl;
import com.wspa.vask.archiveservice.document.model.DocumentImpl;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostgresDocumentRepository implements DocumentRepository {

    @Override
    public void addDocument(List<DescriptorImpl> descriptors) {
    }

    @Override
    public DocumentImpl getDocument(String documentId) {
        return null;

    }
}
