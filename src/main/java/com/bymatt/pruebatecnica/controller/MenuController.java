package com.bymatt.pruebatecnica.controller;

import com.bymatt.pruebatecnica.dto.response.StandardResponseDto;
import com.bymatt.pruebatecnica.entity.MenuEntity;
import com.bymatt.pruebatecnica.services.MenuServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.bymatt.pruebatecnica.dto.response.StandardResponseDto.GenerateHttpResponse;

@RestController
@RequestMapping("/api/v1/menu")
public class MenuController {
    @Autowired
    private MenuServices menuServices;

    @GetMapping("/list")
    public ResponseEntity<StandardResponseDto> listMenu(Pageable pageable) {
        var servicesResponse = menuServices.getAllMenu(PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()));
        return GenerateHttpResponse(servicesResponse);
    }
}
