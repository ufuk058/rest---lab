package com.client_lab.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {
    /*
     Endpoint: /api/v1/address/{addressNo}
     HTTP Status Code: 200

     JSON Response Body:
     "success": true
     "message": "Address <addressNo> is successfully retrieved."
     "code":200
     "data":<address data>
    */




    /*
      Endpoint: /api/v1/address/{addressNo}

      JSON Response Body:
      <updated address data>
     */
}
