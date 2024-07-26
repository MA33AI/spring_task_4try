
package com.example.spring_project_4Try.component.controller;

import com.example.spring_project_4Try.component.service.TelephoneService;
import com.example.spring_project_4Try.programObject.dto.EmployeeRestDto;
import com.example.spring_project_4Try.programObject.dto.TelephoneRestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/telephone")
@RequiredArgsConstructor
public class TelephoneRestController {

    private final TelephoneService telephoneService;

    @PostMapping("/create")
    public TelephoneRestDto createTelephone(@RequestBody TelephoneRestDto telephoneRestDto) {
        return telephoneService.createTelephone(telephoneRestDto);
    }
}

