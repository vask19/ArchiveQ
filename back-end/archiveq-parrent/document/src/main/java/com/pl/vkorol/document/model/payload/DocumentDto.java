package com.pl.vkorol.document.model.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DocumentDto {

    @JsonProperty("documentId")
    private String documentName;
    @JsonProperty("descriptors")
    private List<DescriptorDto> descriptors;
}
