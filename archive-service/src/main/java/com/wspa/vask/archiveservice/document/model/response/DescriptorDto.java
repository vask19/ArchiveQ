package com.wspa.vask.archiveservice.document.model.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public record DescriptorDto(
        @JsonProperty("name")
        String name,
        @JsonProperty("value")
        String value) {
}
