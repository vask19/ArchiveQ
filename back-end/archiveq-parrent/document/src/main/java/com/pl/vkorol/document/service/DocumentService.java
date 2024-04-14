package com.pl.vkorol.document.service;


import com.pl.vkorol.document.model.Document;

public interface DocumentService {

    void addDocument(String documentMessage);
    Document getDocument(String documentId);


}
