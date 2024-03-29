package com.wspa.vask.archiveservice.document.model;

import com.wspa.vask.archiveservice.document.BaseEntity;

import java.util.List;

public interface Document extends BaseEntity {

    List<? extends Descriptor> getDescriptors();
    Descriptor getDescriptor(String name);
    void addDescriptor(Descriptor descriptor);
    File getFileRepresentation(Integer index);
    List<File> getFileRepresentation();
    void addFileRepresentation(File file);
}
