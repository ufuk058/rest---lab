package com.client_lab.service.impl;

import com.client_lab.client.CountryClient;
import com.client_lab.client.WeatherClient;
import com.client_lab.dto.AddressDTO;
import com.client_lab.dto.weather.WeatherResponse;
import com.client_lab.entity.Address;
import com.client_lab.exception.NotFoundException;
import com.client_lab.repository.AddressRepository;
import com.client_lab.service.AddressService;
import com.client_lab.util.MapperUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Value("${access_key}")
    private String access_key;
    private final AddressRepository addressRepository;
    private final MapperUtil mapperUtil;
    private final WeatherClient weatherClient;
    private final CountryClient countryClient;

    public AddressServiceImpl(AddressRepository addressRepository, MapperUtil mapperUtil, WeatherClient weatherClient, CountryClient countryClient) {
        this.addressRepository = addressRepository;
        this.mapperUtil = mapperUtil;
        this.weatherClient = weatherClient;
        this.countryClient = countryClient;
    }

    @Override
    public AddressDTO findByAddressNo(String addressNo) {

        Address foundAddress= addressRepository.findByAddressNo(addressNo).orElseThrow(
                ()->new NotFoundException("No address found")
        );

        AddressDTO addressDTO= mapperUtil.convert(foundAddress, new AddressDTO());
        addressDTO.setCurrentTemperature(retrieveTemperatureByCity(addressDTO.getCity()));
        addressDTO.setFlag(countryClient.retrieveFlagByCountry(addressDTO.getCountry()));

        return addressDTO;
    }

    private Integer retrieveTemperatureByCity(String city){
        WeatherResponse weatherResponse= weatherClient.getCurrentWeather(access_key,city);
        if (weatherResponse == null || weatherResponse.getCurrent() == null) {

            return null;
        }
        Integer temperature=weatherResponse.getCurrent().getTemperature();

        return temperature;
    }

    @Override
    public AddressDTO update(String addressNo, AddressDTO addressDTO) {
        Address foundAddress= addressRepository.findByAddressNo(addressNo).orElseThrow(
                ()->new NotFoundException("No address found")
        );
        Address addressToUpdate=mapperUtil.convert(addressDTO, new Address());
        addressToUpdate.setAddressNo(addressNo);
        addressToUpdate.setId(foundAddress.getId());
        Address updatedAddress= addressRepository.save(addressToUpdate);


        return mapperUtil.convert(updatedAddress,new AddressDTO());
    }
}
