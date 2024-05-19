package com.pl.vkorol.document.model.payload.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostArchiveDocument {

    private String documentName;
    @JsonProperty("selectedDescriptors")
    private List<PostArchiveDescriptor> archiveDescriptors;
}
