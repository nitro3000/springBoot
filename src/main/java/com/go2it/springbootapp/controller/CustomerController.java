package com.go2it.springbootapp.controller;

import com.go2it.springbootapp.dto.CustomerDto;
import com.go2it.springbootapp.utils.CustomerUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {
    @GetMapping
    public ResponseEntity getAllCustomers(){
        List<CustomerDto>customerDtoList= CustomerUtils.getCustomersDto ();
        if (customerDtoList.isEmpty ()){
            return new ResponseEntity (HttpStatus.NO_CONTENT);// backend worked fine, but no content found, return status code
        }
        StringBuilder sb =new StringBuilder ();
        sb.append ("[");                                                                           //  open JSON Array
        for(CustomerDto c :customerDtoList){
            sb.append ("{");                                                                  // start JSON object
            sb.append("'name': '").append(c.getName()).append("',");
            sb.append("'address': '").append(c.getAddress()).append("',");
            sb.append("'dateOfBirth': '").append(c.getDateOfBirth()).append("'").append("},"); // end JSON object + add comma
        }
        sb.append("]");                                                                             // end JSON Array
        return new ResponseEntity(sb, HttpStatus.OK);
    }
}
