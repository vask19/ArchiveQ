package com.pl.vkorol.document.mapper;

import com.pl.vkorol.document.model.ArchiveDescriptor;
import com.pl.vkorol.document.model.request.ArchiveDescriptorDto;
import org.springframework.stereotype.Component;

@Component
public class ArchiveDescriptorMapper {

    public ArchiveDescriptor archiveDescriptorDtoToArchiveDescriptor(ArchiveDescriptorDto archiveDescriptorDto) {
        return new ArchiveDescriptor(archiveDescriptorDto.getName(),
                archiveDescriptorDto.getType(),
                archiveDescriptorDto.getMaxLength(),
                archiveDescriptorDto.getDescription());
    }
}
