package com.pl.vkorol.document.repository;

import com.pl.vkorol.document.model.DescriptorImpl;
import com.pl.vkorol.document.model.DocumentImpl;
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
