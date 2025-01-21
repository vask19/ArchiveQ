package com.pl.vkorol.search.kafka

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

import com.fasterxml.jackson.databind.ObjectMapper
import com.pl.vkorol.search.mapper.DocumentMapper
import com.pl.vkorol.search.model.kafka.DocumentMessage
import com.pl.vkorol.search.service.DocumentService
import reactor.core.publisher.Mono

@Component
class DocumentMessageListener(private val objectMapper: ObjectMapper,
                              private val documentService: DocumentService,
                            private val documentMapper: DocumentMapper) {

    @KafkaListener(topics = ["document"], groupId = "search")
    fun consume(message: String?) {
        if (message == null) {
            println("Received null or empty message")
            return
        }
        Mono.just(message)
            .map { objectMapper.readValue(it, DocumentMessage::class.java) }
            .map { documentMapper.toDocumentIndex(it) }
            .flatMap { documentIndex ->
                documentService.saveDocument(documentIndex)
            }
            .doOnSuccess {
                println("Successfully processed message: $message")
            }
            .doOnError { error ->
                println("Error processing message: $message")
                error.printStackTrace()
            }
            .subscribe()
    }
}
