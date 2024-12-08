package com.client_lab.service.impl;

import com.client_lab.dto.AddressDTO;
import com.client_lab.entity.Address;
import com.client_lab.exception.NotFoundException;
import com.client_lab.repository.AddressRepository;
import com.client_lab.service.AddressService;
import com.client_lab.util.MapperUtil;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final MapperUtil mapperUtil;

    public AddressServiceImpl(AddressRepository addressRepository, MapperUtil mapperUtil) {
        this.addressRepository = addressRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public AddressDTO findByAddressNo(String addressNo) {

        Address foundAddress= addressRepository.findByAddressNo(addressNo).orElseThrow(
                ()->new NotFoundException("No address found")
        );

        return mapperUtil.convert(foundAddress, new AddressDTO());
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
