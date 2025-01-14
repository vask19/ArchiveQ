package com.pl.vkorol.search.service

import com.pl.vkorol.search.model.item.Document
import com.pl.vkorol.search.repository.DocumentRepository
import org.springframework.data.elasticsearch.core.ReactiveElasticsearchOperations
import org.springframework.data.elasticsearch.core.query.Criteria
import org.springframework.data.elasticsearch.core.query.CriteriaQuery
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class DocumentService(
    private val documentRepository: DocumentRepository,
    private val reactiveElasticsearchOperations: ReactiveElasticsearchOperations
) {

    fun saveDocument(document: Document): Mono<Document> = documentRepository.save(document)

    fun findDocumentById(id: String): Mono<Document> = documentRepository.findById(id)

    fun findAllDocuments(): Flux<Document> = documentRepository.findAll()

    fun findDocumentsByDescriptor(name: String, value: String): Flux<Document> {
        val criteria = Criteria.where("descriptors.name").`is`(name)
            .and("descriptors.value").`is`(value)
        val query = CriteriaQuery(criteria)
        return reactiveElasticsearchOperations.search(query, Document::class.java)
            .map { searchHit: org.springframework.data.elasticsearch.core.SearchHit<Document> -> searchHit.content }
    }
}
