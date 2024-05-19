package com.pl.vkorol.document.mapper;

import com.pl.vkorol.document.model.entity.ArchiveDescriptor;
import com.pl.vkorol.document.model.payload.request.ArchiveDescriptorDto;
import org.springframework.stereotype.Component;

@Component
public class ArchiveDescriptorMapper {

    public ArchiveDescriptor archiveDescriptorDtoToArchiveDescriptor(ArchiveDescriptorDto archiveDescriptorDto) {
        return new ArchiveDescriptor(archiveDescriptorDto.getName(),
                archiveDescriptorDto.getType(),
                archiveDescriptorDto.getMaxLength(),
                archiveDescriptorDto.getDescription());
    }

    public ArchiveDescriptorDto archiveDescriptorToArchiveDescriptorDto(ArchiveDescriptor archiveDescriptor) {
        return new ArchiveDescriptorDto(archiveDescriptor.getName(),
                archiveDescriptor.getType(),
                archiveDescriptor.getMaxLength(),
                archiveDescriptor.getDescription());
    }
}
