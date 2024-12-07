package com.pl.vkorol.document.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity(name = "archive_descriptor")
@Table()
@Data
@NoArgsConstructor
public class ArchiveDescriptor implements BaseEntity {

    @Id
    @Column(name = "archive_descriptor_uuid")
    private String uuid;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @Column(name = "max_length")
    private String maxLength;
    @Column(name = "description")
    private String description;

    public ArchiveDescriptor(String name, String type, String maxLength, String description) {
        if (uuid == null) {
            this.uuid = generateUUID();
        }
        this.name = name;
        this.type = type;
        this.maxLength = maxLength;
        this.description = description;
    }

    public ArchiveDescriptor(String name) {
        this.name = name;
    }

    @Override
    public String generateUUID() {
        String prefix = "archive-desc";
        return prefix + "_" + UUID.randomUUID();
    }
}
