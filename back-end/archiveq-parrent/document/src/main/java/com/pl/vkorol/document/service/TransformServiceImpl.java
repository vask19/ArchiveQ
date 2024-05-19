package com.pl.vkorol.document.service;

import com.pl.vkorol.document.model.entity.*;
import com.pl.vkorol.document.model.payload.DocumentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransformServiceImpl implements TransformService {

    private final DescriptorService descriptorService;
    private final DocumentService documentService;

    @Override
    public DocumentInstance toDocumentInstance(DocumentDto documentDto) {
        ArchiveDocument archiveDocument = documentService.getDocumentByName(documentDto.getDocumentName());
        DocumentInstance documentInstance = new DocumentInstance();
        List<Descriptor> descriptorList = documentDto.getDescriptorDtoList()
                .stream()
                .map(descriptorDto -> {
                    ArchiveDescriptor archiveDescriptor = descriptorService.getDescriptorByName(descriptorDto.name());
                    return new Descriptor(archiveDescriptor, descriptorDto.value(), documentInstance);
                })
                .toList();
        documentInstance.setTemplate(archiveDocument);
        documentInstance.setDescriptors(descriptorList);
        return documentInstance;
    }
}
