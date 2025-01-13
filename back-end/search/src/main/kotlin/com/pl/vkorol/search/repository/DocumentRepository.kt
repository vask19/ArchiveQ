package com.pl.vkorol.search.repository;
import com.pl.vkorol.search.model.Document
import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;
import reactor.core.publisher.Flux

interface DocumentRepository : ReactiveElasticsearchRepository<Document, String> {
    fun findByName(name: String): Flux<Document>;
}
