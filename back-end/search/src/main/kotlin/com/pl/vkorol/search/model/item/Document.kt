package com.pl.vkorol.search.model.item

import org.springframework.data.annotation.Id

@org.springframework.data.elasticsearch.annotations.Document(indexName = "documents")
data class Document(
    @Id val uuid: String?,
    val name: String,
    val description: String,
    val descriptors: List<Descriptor>
)
