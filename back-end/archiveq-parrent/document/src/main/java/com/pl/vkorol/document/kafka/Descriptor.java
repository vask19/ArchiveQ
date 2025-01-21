package com.pl.vkorol.document.kafka;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Descriptor(String name, String value) {
}
