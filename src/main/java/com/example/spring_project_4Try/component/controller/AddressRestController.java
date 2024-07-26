
package com.example.spring_project_4Try.component.controller;

import com.example.spring_project_4Try.component.service.AddressService;
import com.example.spring_project_4Try.programObject.dto.AddressRestDto;
import com.example.spring_project_4Try.programObject.dto.EmployeeRestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/address")
@RequiredArgsConstructor
public class AddressRestController {

    private final AddressService addressService;

    @PostMapping("/create")
    public AddressRestDto createAddress(@RequestBody AddressRestDto addressRestDto) {
        return addressService.createAddress(addressRestDto);
    }
}
