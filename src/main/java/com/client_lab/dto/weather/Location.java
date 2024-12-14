package com.client_lab.dto.weather;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.annotation.Generated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "country",
        "region",
        "lat",
        "lon",
        "timezone_id",
        "localtime",
        "localtime_epoch",
        "utc_offset"
})
@Generated("jsonschema2pojo")
public class Location {

    @JsonProperty("name")
    private String name;
    @JsonProperty("country")
    private String country;
    @JsonProperty("region")
    private String region;
    @JsonProperty("lat")
    private String lat;
    @JsonProperty("lon")
    private String lon;
    @JsonProperty("timezone_id")
    private String timezoneId;
    @JsonProperty("localtime")
    private String localtime;
    @JsonProperty("localtime_epoch")
    private Integer localtimeEpoch;
    @JsonProperty("utc_offset")
    private String utcOffset;

}