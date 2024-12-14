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
        "type",
        "query",
        "language",
        "unit"
})
@Generated("jsonschema2pojo")
public class Request {

    @JsonProperty("type")
    private String type;
    @JsonProperty("query")
    private String query;
    @JsonProperty("language")
    private String language;
    @JsonProperty("unit")
    private String unit;


}
