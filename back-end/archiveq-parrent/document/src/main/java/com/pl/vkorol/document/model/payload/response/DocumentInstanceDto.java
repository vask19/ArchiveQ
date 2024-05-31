package com.pl.vkorol.document.model.payload.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pl.vkorol.document.model.payload.DescriptorDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DocumentInstanceDto {

    private String documentUuid;
    private String documentName;
    @JsonProperty("descriptors")
    private List<DescriptorDto> descriptorDtoList;
}
