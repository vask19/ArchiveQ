package com.pl.vkorol.search.controller

import com.pl.vkorol.search.model.index.DocumentIndex
import com.pl.vkorol.search.service.DocumentService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/v1/documents")
@Tag(name = "Document API", description = "Operations related to documents")
class DocumentController(private val documentService: DocumentService) {

    @PostMapping
    @Operation(summary = "Create a new document", description = "Add a new document to the system")
    fun createDocument(@RequestBody documentIndex: DocumentIndex): Mono<DocumentIndex> {
        return documentService.saveDocument(documentIndex)
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a document by ID", description = "Retrieve a document using its unique identifier")
    fun findDocumentById(@PathVariable id: String): Mono<DocumentIndex> {
        return documentService.findDocumentById(id)
    }

    @GetMapping
    @Operation(summary = "Get all documents", description = "Retrieve a list of all documents")
    fun findAllDocuments(): Flux<DocumentIndex> {
        return documentService.findAllDocuments()
    }

    @GetMapping("/search")
    @Operation(
        summary = "Find documents by descriptor",
        description = "Retrieve documents that match the given descriptor name and value"
    )
    fun findDocumentsByDescriptor(@RequestParam name: String, @RequestParam value: String): Flux<DocumentIndex> {
        return documentService.findDocumentsByDescriptor(name, value)
    }

    @GetMapping("/search/text")
    @Operation(
        summary = "Find documents by text",
        description = "Retrieve documents that match the given text in fields like name, description, descriptors.name, or descriptors.value"
    )
    fun findDocumentsByText(@RequestParam text: String): Flux<DocumentIndex> {
        return documentService.findDocumentsByText(text)
    }
}
