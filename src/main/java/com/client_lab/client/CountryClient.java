package com.client_lab.client;

import com.client_lab.dto.country.CountryFlag;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
public class CountryClient {

    public  String retrieveFlagByCountry(String country){

        RestClient restClient= RestClient.builder()
                .baseUrl("https://restcountries.com/v3.1").build();

        List<CountryFlag>  list = restClient.get().uri("/name/{coutryName}",country).retrieve()
                .body(new ParameterizedTypeReference<List<CountryFlag>>() {
                });

        if (list ==null || list.get(0)==null){
            return null;
        }
        return list.get(0).getFlags().getPng();
    }
}
