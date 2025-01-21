package com.pl.vkorol.search.model.kafka

import com.pl.vkorol.search.model.Descriptor

data class DocumentMessage(
    val documentUuid: String,
    val name: String,
    val descriptors: List<Descriptor>
)
