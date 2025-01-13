package com.pl.vkorol.search.service

import com.pl.vkorol.search.model.Document
import com.pl.vkorol.search.repository.DocumentRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class DocumentService(private val documentRepository: DocumentRepository) {

    fun saveDocument(document: Document) : Mono<Document> = documentRepository.save(document);

    fun findDocumentById(id: String) : Mono<Document> = documentRepository.findById(id);

    fun findAllDocuments() : Flux<Document> = documentRepository.findAll();
}
