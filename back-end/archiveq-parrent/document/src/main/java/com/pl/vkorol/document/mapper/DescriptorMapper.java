package com.pl.vkorol.document.mapper;

import com.pl.vkorol.document.model.Descriptor;
import com.pl.vkorol.document.model.response.DescriptorDto;
import org.springframework.stereotype.Component;

@Component
public class DescriptorMapper {

    public Descriptor descriptorDtoToDescriptor(DescriptorDto descriptorDto) {
        return new Descriptor();
    }

    public DescriptorDto descriptorToDescriptorDto(Descriptor descriptor) {
        return new DescriptorDto("", "");
    }
}
