package com.pl.vkorol.document.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity(name = "archive_document")
@Table()
@Data
@NoArgsConstructor
public class ArchiveDocument implements BaseEntity{

    @Id
    @Column(name = "archive_document_uuid")
    private String uuid;
    @Column(name = "document_name")
    private String documentName;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "archive_document_descriptor",
    joinColumns = @JoinColumn(name = "archive_document_uuid"),
    inverseJoinColumns = @JoinColumn(name = "archive_descriptor_uuid"))
    private List<ArchiveDescriptor> descriptors;

    public ArchiveDocument(String documentName, List<ArchiveDescriptor> descriptors) {
        if (uuid == null) {
            this.uuid = generateUUID();
        }
        this.documentName = documentName;
        this.descriptors = descriptors;
    }

    @Override
    public String generateUUID() {
        String prefix = "archive-doc";
        return prefix + "_" + UUID.randomUUID();
    }
}
