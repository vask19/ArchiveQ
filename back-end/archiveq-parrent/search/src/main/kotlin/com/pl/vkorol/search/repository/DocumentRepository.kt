package com.pl.vkorol.search.repository;
import com.pl.vkorol.search.model.index.DocumentIndex
import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;
import reactor.core.publisher.Flux

interface DocumentRepository : ReactiveElasticsearchRepository<DocumentIndex, String> {

    fun findByName(name: String): Flux<DocumentIndex>;
}
