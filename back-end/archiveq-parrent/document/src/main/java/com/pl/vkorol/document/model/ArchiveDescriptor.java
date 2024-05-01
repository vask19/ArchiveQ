package com.pl.vkorol.document.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity(name = "archive_descriptor")
@Table(name = "archive_descriptor")
@Data
@NoArgsConstructor
public class ArchiveDescriptor implements BaseEntity{

    @Id
    @Column(name = "archiveDescriptorUuid")
    private String uuid;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @Column(name = "maxLength")
    private String maxLength;
    @Column(name = "description")
    private String description;

    public ArchiveDescriptor(String name, String type, String maxLength, String description) {
        this.uuid = generateUUID();
        this.name = name;
        this.type = type;
        this.maxLength = maxLength;
        this.description = description;
    }

    @Override
    public String generateUUID() {
        String prefix = "archive-desc";
        return prefix + "_" + UUID.randomUUID();
    }
}
