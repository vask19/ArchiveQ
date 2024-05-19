package com.pl.vkorol.document.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;


@Entity(name = "document_descriptor")
@Table()
public class Descriptor implements BaseEntity {

    @Id
    @Column(name = "document_descriptor_uuid")
    private String uuid;

    @ManyToOne
    @JoinColumn(name = "document_instance_uuid", nullable = false)
    @ToString.Exclude
    private DocumentInstance documentInstance;

    @ManyToOne
    @JoinColumn(name = "archive_descriptor_uuid", nullable = false)
    @ToString.Exclude
    private ArchiveDescriptor archiveDescriptor;

    @Column(name = "value", nullable = false)
    private String value;

    public Descriptor() {
        this.uuid = generateUUID();
    }

    public Descriptor(ArchiveDescriptor archiveDescriptor, String value, DocumentInstance documentInstance) {
        this.uuid = generateUUID();
        this.archiveDescriptor = archiveDescriptor;
        this.value = value;
        this.documentInstance = documentInstance;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public DocumentInstance getDocumentInstance() {
        return documentInstance;
    }

    public void setDocumentInstance(DocumentInstance documentInstance) {
        this.documentInstance = documentInstance;
    }

    public ArchiveDescriptor getArchiveDescriptor() {
        return archiveDescriptor;
    }

    public void setArchiveDescriptor(ArchiveDescriptor archiveDescriptor) {
        this.archiveDescriptor = archiveDescriptor;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String generateUUID() {
        String prefix = "descriptor";
        return prefix + "_" + UUID.randomUUID();
    }
}
