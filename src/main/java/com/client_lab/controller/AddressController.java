package com.client_lab.controller;

import com.client_lab.dto.AddressDTO;
import com.client_lab.dto.ResponseWrapper;
import com.client_lab.entity.Address;
import com.client_lab.exception.NotFoundException;
import com.client_lab.repository.AddressRepository;
import com.client_lab.service.AddressService;
import com.client_lab.util.MapperUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {
    private final AddressRepository addressRepository;
    private final AddressService addressService;
    private final MapperUtil mapperUtil;

    public AddressController(AddressRepository addressRepository, AddressService addressService, MapperUtil mapperUtil) {
        this.addressRepository = addressRepository;
        this.addressService = addressService;
        this.mapperUtil = mapperUtil;
    }

  /*
     Endpoint: /api/v1/address/{addressNo}
     HTTP Status Code: 200

     JSON Response Body:
     "success": true
     "message": "Address <addressNo> is successfully retrieved."
     "code":200
     "data":<address data>
    */

    @GetMapping("/{addressNo}")
    public ResponseEntity<ResponseWrapper> getAddressByAddressNo(@PathVariable String addressNo){
        AddressDTO address=addressService.findByAddressNo(addressNo);

        return ResponseEntity.ok(ResponseWrapper.builder()
                .success(true)
                .message("Address :"+ addressNo +" is successfully retrieved")
                        .code(HttpStatus.OK.value())
                .data(mapperUtil.convert(address, new AddressDTO())).build());
    }



    /*
      Endpoint: /api/v1/address/{addressNo}

      JSON Response Body:
      <updated address data>
     */

    @PutMapping("/{addressNo}")
    public ResponseEntity<ResponseWrapper> updateAddress(@PathVariable String addressNo,
                                                         @RequestBody AddressDTO addressDTO){


        addressService.update(addressNo,addressDTO);

      return ResponseEntity.status(HttpStatus.CREATED)
              .body(ResponseWrapper.builder()
                      .success(true)
                      .message("Address: "+addressNo+" successfully updated")
                      .code(HttpStatus.CREATED.value())
                      .data(addressDTO).build());

    }
}
