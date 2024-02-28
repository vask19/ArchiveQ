package com.wspa.vask.archiveservice.springkafkaconsumer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Calendar;

@JsonPropertyOrder({
        "appName",
        "procId",
        "timestamp",
        "hostname",
        "severity",
        "facility",
		"organizationEventInfo",
		"systemEventInfo",

})
@JsonIgnoreProperties(ignoreUnknown = true)
public class KafkaMessage {
    @JsonProperty("appName")
    private String appName;
    @JsonProperty("procId")
    private String procId;
    @JsonProperty("timestamp")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZZ")
    private Calendar timestamp;
    @JsonProperty("hostname")
    private String hostname;
    @JsonProperty("severity")
    private Integer severity;
    @JsonProperty("facility")
    private Integer facility;
    @JsonProperty("organizationEventDto")
    private OrganizationEventDto organizationEventDto;
    @JsonProperty("systemEventDto")
    private SystemEventDto systemEventDto;

    @Override
    public String toString() {
        return "KafkaMessage{" +
                "appName='" + appName + '\'' +
                ", procId='" + procId + '\'' +
                ", timestamp=" + timestamp +
                ", hostname='" + hostname + '\'' +
                ", severity=" + severity +
                ", facility=" + facility +
                ", organizationEventDto=" + organizationEventDto +
                ", systemEventDto=" + systemEventDto +
                '}';
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getProcId() {
        return procId;
    }

    public void setProcId(String procId) {
        this.procId = procId;
    }

    public Calendar getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Calendar timestamp) {
        this.timestamp = timestamp;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public Integer getSeverity() {
        return severity;
    }

    public void setSeverity(Integer severity) {
        this.severity = severity;
    }

    public Integer getFacility() {
        return facility;
    }

    public void setFacility(Integer facility) {
        this.facility = facility;
    }

    public OrganizationEventDto getOrganizationEventDto() {
        return organizationEventDto;
    }

    public void setOrganizationEventDto(OrganizationEventDto organizationEventDto) {
        this.organizationEventDto = organizationEventDto;
    }

    public SystemEventDto getSystemEventDto() {
        return systemEventDto;
    }

    public void setSystemEventDto(SystemEventDto systemEventDto) {
        this.systemEventDto = systemEventDto;
    }
}
