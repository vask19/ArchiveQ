package com.pl.vkorol.document.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity(name = "descriptor")
@Table(name = "descriptor", schema = "archive_q")
public class DescriptorImpl implements BaseEntity {

    @Id
    @Column(name = "descriptorUuid")
    private String uuid;
    @ManyToMany(mappedBy = "descriptors")
    private List<DocumentImpl> documents;
    @Column(name = "name")
    private String name;
    @Column(name = "value")
    private String value;

    public DescriptorImpl(String name, String value) {
        super();
        this.name = name;
        this.value = value;
        this.uuid = generateUUID();
    }

    public DescriptorImpl() {
        this.uuid = generateUUID();
    }

    @Override
    public String generateUUID() {
        String prefix = "desc";
        return prefix + "_" + UUID.randomUUID();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public List<DocumentImpl> getDocuments() {
        return documents;
    }

    public void setDocuments(List<DocumentImpl> documents) {
        this.documents = documents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
