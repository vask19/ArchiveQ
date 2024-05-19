package com.pl.vkorol.document.model.payload.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostArchiveDescriptor {
    @JsonProperty("descriptor")
    private String name;
}
