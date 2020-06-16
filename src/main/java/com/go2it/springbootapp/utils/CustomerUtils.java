package com.go2it.springbootapp.utils;

import com.go2it.springbootapp.dto.CustomerDto;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class CustomerUtils {
    public static List<CustomerDto>getCustomersDto(){
        List<CustomerDto>customerDtoList=new ArrayList<> ();
        for (int i =0;i<5;i++){
            CustomerDto customerDto =new CustomerDto (String.valueOf (((char)(i+30))), LocalDate.of(2020, Month.APRIL,i+4),"1000 main steet,New York NY"+i);
            customerDtoList.add(customerDto);
        }
     return customerDtoList;
    }

}
