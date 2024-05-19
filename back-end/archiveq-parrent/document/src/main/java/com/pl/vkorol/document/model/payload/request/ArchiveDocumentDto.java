package com.pl.vkorol.document.model.payload.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ArchiveDocumentDto {

    private String documentName;
    @JsonProperty("descriptors")
    private List<ArchiveDescriptorDto> descriptorDtoList;
}
