package com.pl.vkorol.document.repository;

import com.pl.vkorol.document.model.SearchDocumentInstanceQuery;
import com.pl.vkorol.document.model.entity.Descriptor;
import com.pl.vkorol.document.model.entity.DocumentInstance;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CustomDocumentRepositoryImpl implements DocumentRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<DocumentInstance> findByDescriptorsAndArchiveDocumentName(SearchDocumentInstanceQuery searchQuery) {
        String jpqlQuery = searchQuery.generateJpqlQuery();
        Query query = entityManager.createQuery(jpqlQuery, DocumentInstance.class);
        searchQuery.setQueryParameters(query);
        return query.getResultList();
    }

}
