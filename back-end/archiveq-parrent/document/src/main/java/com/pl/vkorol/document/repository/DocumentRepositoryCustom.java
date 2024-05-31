package com.pl.vkorol.document.repository;

import com.pl.vkorol.document.model.SearchDocumentInstanceQuery;
import com.pl.vkorol.document.model.entity.DocumentInstance;
import jakarta.transaction.Transactional;

import java.util.List;

@Transactional
public
interface DocumentRepositoryCustom {

    List<DocumentInstance> findByDescriptorsAndArchiveDocumentName(SearchDocumentInstanceQuery query);
}
