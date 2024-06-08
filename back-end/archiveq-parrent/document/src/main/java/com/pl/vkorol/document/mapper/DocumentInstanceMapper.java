package com.pl.vkorol.document.mapper;

import com.pl.vkorol.document.model.entity.ArchiveDescriptor;
import com.pl.vkorol.document.model.entity.Descriptor;
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
}
