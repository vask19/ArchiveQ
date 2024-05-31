package com.pl.vkorol.document.mapper;

import com.pl.vkorol.document.model.entity.Descriptor;
import com.pl.vkorol.document.model.payload.DescriptorDto;
import org.springframework.stereotype.Component;

@Component
public class DescriptorMapper {

    public DescriptorDto descriptorToDescriptorDto(Descriptor descriptor) {
        return new DescriptorDto(descriptor.getArchiveDescriptor().getName(), descriptor.getValue());
    }
}
