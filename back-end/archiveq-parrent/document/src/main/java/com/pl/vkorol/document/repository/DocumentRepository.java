package com.pl.vkorol.document.repository;


import com.pl.vkorol.document.model.Descriptor;
import com.pl.vkorol.document.model.Document;

import java.util.List;

public interface DocumentRepository  {

    void addDocument(List<Descriptor> descriptors);
    Document getDocument(String documentId);
}
