package com.pl.vkorol.search.model.index

import com.pl.vkorol.search.model.Descriptor
import org.springframework.data.annotation.Id

@org.springframework.data.elasticsearch.annotations.Document(indexName = "documents")
data class DocumentIndex(
    @Id val uuid: String?,
    val name: String,
    val description: String,
    val descriptors: List<Descriptor>
)
