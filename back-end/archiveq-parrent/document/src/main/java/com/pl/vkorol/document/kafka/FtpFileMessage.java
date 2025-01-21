package com.pl.vkorol.document.kafka;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FtpFileMessage extends KafkaMessage{

    @JsonProperty("documentUuid")
    private String documentUuid;
    @JsonProperty("fileName")
    private String fileName;
    @JsonProperty("content")
    private byte[] content;
}
