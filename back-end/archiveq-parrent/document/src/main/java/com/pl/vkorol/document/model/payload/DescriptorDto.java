package com.pl.vkorol.document.model.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record DescriptorDto(

        @JsonProperty("name")
        String name,
        @JsonProperty("value")
        String value) {
}
