package com.pl.vkorol.search.model

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document

@Document(indexName = "documents")
data class Document(
    @Id val id: String?,
    val name: String,
    val description: String,
)
