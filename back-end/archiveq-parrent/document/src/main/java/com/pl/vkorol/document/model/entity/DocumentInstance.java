package com.pl.vkorol.document.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity(name = "document_instance")
@Table()
public class DocumentInstance implements BaseEntity {

    @Id
    @Column(name = "document_instance_uuid")
    private String id;

    @ManyToOne
    @JoinColumn(name = "archive_document_uuid", nullable = false)
    private ArchiveDocument template;

    @OneToMany(mappedBy = "documentInstance", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<Descriptor> descriptors;

    public DocumentInstance() {
        this.id = generateUUID();
    }

    @Override
    public String generateUUID() {
        String prefix = "instance-doc";
        return prefix + "_" + UUID.randomUUID();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DocumentInstance that = (DocumentInstance) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArchiveDocument getTemplate() {
        return template;
    }

    public void setTemplate(ArchiveDocument template) {
        this.template = template;
    }

    public List<Descriptor> getDescriptors() {
        return descriptors;
    }

    public void setDescriptors(List<Descriptor> descriptors) {
        this.descriptors = descriptors;
    }
}
