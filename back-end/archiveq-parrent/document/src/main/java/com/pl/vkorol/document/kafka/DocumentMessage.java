package com.pl.vkorol.document.kafka;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DocumentMessage extends KafkaMessage{

    String documentUuid;
    String name;
    List<Descriptor> descriptors;
}
