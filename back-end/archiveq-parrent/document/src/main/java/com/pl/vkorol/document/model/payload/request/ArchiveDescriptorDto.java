package com.pl.vkorol.document.model.payload.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ArchiveDescriptorDto {

    @JsonProperty("name")
    private String name;
    @JsonProperty("type")
    private String type;
    @JsonProperty("maxLength")
    private String maxLength;
    @JsonProperty("description")
    private String description;
}
