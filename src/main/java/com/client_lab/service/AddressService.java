package com.client_lab.service;

import com.client_lab.dto.AddressDTO;

public interface AddressService {

    AddressDTO findByAddressNo(String addressNo);
    AddressDTO update(String addressNo, AddressDTO addressDTO);
}
