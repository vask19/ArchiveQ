package com.pl.vkorol.document.repository;


import com.pl.vkorol.document.model.DescriptorImpl;
import com.pl.vkorol.document.model.DocumentImpl;

import java.util.List;

public interface DocumentRepository  {

    void addDocument(List<DescriptorImpl> descriptors);
    DocumentImpl getDocument(String documentId);
}
