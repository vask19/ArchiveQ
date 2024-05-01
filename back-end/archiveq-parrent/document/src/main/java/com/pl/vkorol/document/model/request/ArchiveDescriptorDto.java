package com.pl.vkorol.document.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ArchiveDescriptorDto {

    private String name;
    private String type;
    private String maxLength;
    private String description;
}
