package com.pl.vkorol.document.model.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DescriptorDto(
        @JsonProperty("name")
        String name,
        @JsonProperty("value")
        String value) {
}
