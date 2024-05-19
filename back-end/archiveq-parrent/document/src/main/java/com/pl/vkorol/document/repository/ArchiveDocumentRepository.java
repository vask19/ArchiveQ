package com.pl.vkorol.document.repository;

import com.pl.vkorol.document.model.entity.ArchiveDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArchiveDocumentRepository extends JpaRepository<ArchiveDocument, String> {

    Optional<ArchiveDocument> findByDocumentName(String docName);
}
