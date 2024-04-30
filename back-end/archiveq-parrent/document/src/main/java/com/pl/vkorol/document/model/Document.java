package com.pl.vkorol.document.model;


import java.util.List;

public interface Document extends BaseEntity {

    List<? extends Descriptor> getDescriptors();
    Descriptor getDescriptor(String name);
    void addDescriptor(Descriptor descriptor);
    File getFileRepresentation(Integer index);
    List<File> getFileRepresentation();
    void addFileRepresentation(File file);
}
