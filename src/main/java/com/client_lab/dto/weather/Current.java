package com.client_lab.dto.weather;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.annotation.Generated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "observation_time",
        "temperature",
        "weather_code",
        "weather_icons",
        "weather_descriptions",
        "wind_speed",
        "wind_degree",
        "wind_dir",
        "pressure",
        "precip",
        "humidity",
        "cloudcover",
        "feelslike",
        "uv_index",
        "visibility",
        "is_day"
})
@Generated("jsonschema2pojo")
public class Current {
    @JsonProperty("observation_time")
    private String observationTime;
    @JsonProperty("temperature")
    private Integer temperature;
    @JsonProperty("weather_code")
    private Integer weatherCode;
    @JsonProperty("weather_icons")
    private List<String> weatherIcons;
    @JsonProperty("weather_descriptions")
    private List<String> weatherDescriptions;
    @JsonProperty("wind_speed")
    private Integer windSpeed;
    @JsonProperty("wind_degree")
    private Integer windDegree;
    @JsonProperty("wind_dir")
    private String windDir;
    @JsonProperty("pressure")
    private Integer pressure;
    @JsonProperty("precip")
    private Integer precip;
    @JsonProperty("humidity")
    private Integer humidity;
    @JsonProperty("cloudcover")
    private Integer cloudcover;
    @JsonProperty("feelslike")
    private Integer feelslike;
    @JsonProperty("uv_index")
    private Integer uvIndex;
    @JsonProperty("visibility")
    private Integer visibility;
    @JsonProperty("is_day")
    private String isDay;
}
