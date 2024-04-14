package com.wspa.vask.archiveservice.document.repository;

import com.wspa.vask.archiveservice.document.model.Descriptor;
import com.wspa.vask.archiveservice.document.model.DescriptorImpl;
import com.wspa.vask.archiveservice.document.model.Document;
import com.wspa.vask.archiveservice.document.model.DocumentImpl;

import java.util.List;

public interface DocumentRepository  {

    void addDocument(List<DescriptorImpl> descriptors);
    DocumentImpl getDocument(String documentId);
}
