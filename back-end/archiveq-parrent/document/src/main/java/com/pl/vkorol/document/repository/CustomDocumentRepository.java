package com.pl.vkorol.document.repository;

import com.pl.vkorol.document.model.entity.DocumentInstance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomDocumentRepository extends JpaRepository<DocumentInstance, String>, DocumentRepositoryCustom {
}

