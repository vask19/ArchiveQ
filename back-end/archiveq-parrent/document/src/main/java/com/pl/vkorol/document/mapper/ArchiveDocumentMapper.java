package com.pl.vkorol.document.mapper;

import com.pl.vkorol.document.model.entity.ArchiveDescriptor;
import com.pl.vkorol.document.model.entity.ArchiveDocument;
import com.pl.vkorol.document.model.payload.request.ArchiveDescriptorDto;
import com.pl.vkorol.document.model.payload.request.ArchiveDocumentDto;
import com.pl.vkorol.document.model.payload.request.PostArchiveDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ArchiveDocumentMapper {

    private final ArchiveDescriptorMapper archiveDescriptorMapper;

    public ArchiveDocument archiveDocumentDtoToArchiveDocument(ArchiveDocumentDto archiveDocumentDto) {
        List<ArchiveDescriptor> descriptors = archiveDocumentDto.getDescriptorDtoList()
                .stream()
                .map(archiveDescriptorMapper::archiveDescriptorDtoToArchiveDescriptor)
                .toList();
        return new ArchiveDocument(archiveDocumentDto.getDocumentName(), descriptors);
    }

    public ArchiveDocumentDto archiveDocumentToArchiveDocumentDto(ArchiveDocument archiveDocument) {
        List<ArchiveDescriptorDto> descriptors = archiveDocument.getDescriptors()
                .stream()
                .map(archiveDescriptorMapper::archiveDescriptorToArchiveDescriptorDto)
                .toList();
        return new ArchiveDocumentDto(archiveDocument.getDocumentName(), descriptors);
    }

    public ArchiveDocument postArchiveDocumentToArchiveDocument(PostArchiveDocument postArchiveDocument) {
        List<ArchiveDescriptor> descriptors = postArchiveDocument.getArchiveDescriptors()
                .stream()
                .map(postArchiveDescriptor -> new ArchiveDescriptor(postArchiveDescriptor.getName()))
                .toList();
        return new ArchiveDocument(postArchiveDocument.getDocumentName(), descriptors);
    }
}
