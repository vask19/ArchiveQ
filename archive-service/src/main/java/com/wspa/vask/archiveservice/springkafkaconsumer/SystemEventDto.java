package com.wspa.vask.archiveservice.springkafkaconsumer;

import com.fasterxml.jackson.annotation.JsonProperty;


public class SystemEventDto {
    @JsonProperty("severity")
 	private String severity;
    @JsonProperty("timestamp")
    private String timestamp;
    @JsonProperty("hostName")
    private String hostName;
    @JsonProperty("eventCode")
    private String eventCode;
    @JsonProperty("eventCategory")
    private String eventCategory;
    @JsonProperty("documentType")
    private String documentType;
    @JsonProperty("serverType")
    private String serverType;
    @JsonProperty("description")
    private String description;

    @Override
    public String toString() {
        return "SystemEventDto{" +
                "severity='" + severity + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", hostName='" + hostName + '\'' +
                ", eventCode='" + eventCode + '\'' +
                ", eventCategory='" + eventCategory + '\'' +
                ", documentType='" + documentType + '\'' +
                ", serverType='" + serverType + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    public String getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(String eventCategory) {
        this.eventCategory = eventCategory;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getServerType() {
        return serverType;
    }

    public void setServerType(String serverType) {
        this.serverType = serverType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
