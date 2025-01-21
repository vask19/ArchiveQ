package com.pl.vkorol.document.mapper;

import com.pl.vkorol.document.kafka.Descriptor;
import com.pl.vkorol.document.kafka.DocumentMessage;
import com.pl.vkorol.document.model.entity.DocumentInstance;
import com.pl.vkorol.document.model.payload.DescriptorDto;
import com.pl.vkorol.document.model.payload.response.DocumentInstanceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DocumentInstanceMapper {

    private final DescriptorMapper descriptorMapper;

    public DocumentInstanceDto documentInstanceToDocumentInstanceDto(DocumentInstance documentInstance) {
        List<DescriptorDto> descriptors = documentInstance.getDescriptors()
                .stream()
                .map(descriptorMapper::descriptorToDescriptorDto)
                .toList();
        return new DocumentInstanceDto(documentInstance.getId(), documentInstance.getTemplate().getDocumentName(),
                descriptors);
    }

    public List<DocumentInstanceDto> documentInstanceListToDocumentInstanceDtoList(List<DocumentInstance> documentInstances) {
        return documentInstances.stream()
                .map(this::documentInstanceToDocumentInstanceDto).toList();
    }

    public DocumentMessage toDocumentMessage(DocumentInstance documentInstance) {
        DocumentMessage documentMessage = new DocumentMessage();
        documentMessage.setDocumentUuid(documentInstance.getId());
        documentMessage.setName(documentInstance.getTemplate().getDocumentName());
        List<Descriptor> descriptorList = documentInstance.getDescriptors()
                .stream().map(descriptor ->
                        new Descriptor(descriptor.getArchiveDescriptor().getName(), descriptor.getValue())).toList();
        documentMessage.setDescriptors(descriptorList);
        return documentMessage;
    }
}
