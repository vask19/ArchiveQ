package com.pl.vkorol.document.repository;

import com.pl.vkorol.document.model.Descriptor;
import com.pl.vkorol.document.model.Document;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostgresDocumentRepository implements DocumentRepository {

    @Override
    public void addDocument(List<Descriptor> descriptors) {
    }

    @Override
    public Document getDocument(String documentId) {
        return null;

    }
}
