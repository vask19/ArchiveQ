package com.pl.vkorol.document.model.payload.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class GetDescriptorsResponse {

    @JsonProperty("descriptors")
    Map<String, String> descriptors;

    public GetDescriptorsResponse(Map<String, String> descriptors) {
        this.descriptors = descriptors;
    }

    public Map<String, String> getDescriptors() {
        return descriptors;
    }

    public void setDescriptors(Map<String, String> descriptors) {
        this.descriptors = descriptors;
    }
}
