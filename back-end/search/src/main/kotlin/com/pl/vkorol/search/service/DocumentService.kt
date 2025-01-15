package com.pl.vkorol.search.service

import com.pl.vkorol.search.model.index.DocumentIndex
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

    fun saveDocument(documentIndex: DocumentIndex): Mono<DocumentIndex> = documentRepository.save(documentIndex)

    fun findDocumentById(id: String): Mono<DocumentIndex> = documentRepository.findById(id)

    fun findAllDocuments(): Flux<DocumentIndex> = documentRepository.findAll()

    fun findDocumentsByDescriptor(name: String, value: String): Flux<DocumentIndex> {
        val criteria = Criteria.where("descriptors.name").`is`(name)
            .and("descriptors.value").`is`(value)
        val query = CriteriaQuery(criteria)
        return reactiveElasticsearchOperations.search(query, DocumentIndex::class.java)
            .map { searchHit: org.springframework.data.elasticsearch.core.SearchHit<DocumentIndex> -> searchHit.content }
    }
}
