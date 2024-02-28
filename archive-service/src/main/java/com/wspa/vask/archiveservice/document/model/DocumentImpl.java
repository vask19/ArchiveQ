package com.wspa.vask.archiveservice.document.model;

import com.wspa.vask.archiveservice.document.BaseEntity;
import jakarta.persistence.*;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;
import java.util.UUID;

@Entity(name = "document")
@Table(name = "document", schema = "archive_q")
public class DocumentImpl implements BaseEntity {

    @Id
    @Column(name = "descriptorUuid")
    private String uuid;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "document_descriptor",
            joinColumns = @JoinColumn(name = "document_id"),
            inverseJoinColumns = @JoinColumn(name = "descriptor_id"))
    private List<DescriptorImpl> descriptors;

    public DocumentImpl(String uuid, List<DescriptorImpl> descriptors) {
        this.uuid = uuid;
        this.descriptors = descriptors;
    }

    public DocumentImpl() {
        this.uuid = generateUUID();
    }

    public String generateUUID() {
        String prefix = "descriptor";
        return prefix + "_" + UUID.randomUUID();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public List<DescriptorImpl> getDescriptors() {
        return descriptors;
    }

    public Descriptor getDescriptor(String name) {
        return null;
    }

    public void addDescriptor(Descriptor descriptor) {
    }

    public File getFileRepresentation(Integer index) {
        return null;
    }

    public List<File> getFileRepresentation() {
        return null;
    }

    public void addFileRepresentation(File file) {

    }

}
