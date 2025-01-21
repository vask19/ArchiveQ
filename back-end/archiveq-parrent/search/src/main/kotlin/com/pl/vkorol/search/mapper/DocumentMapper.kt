package com.pl.vkorol.search.mapper

import com.pl.vkorol.search.model.kafka.DocumentMessage
import com.pl.vkorol.search.model.index.DocumentIndex
import org.springframework.stereotype.Component

@Component
class DocumentMapper {

    fun toDocumentIndex(documentMessage: DocumentMessage): DocumentIndex {
        val documentIndex: DocumentIndex = DocumentIndex(
            documentMessage.documentUuid,
            documentMessage.name,
            "null",
            documentMessage.descriptors
        );
        return documentIndex;
    }
}
