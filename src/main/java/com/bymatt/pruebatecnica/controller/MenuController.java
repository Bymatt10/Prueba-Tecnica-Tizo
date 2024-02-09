package com.bymatt.pruebatecnica.controller;

import com.bymatt.pruebatecnica.dto.response.StandardResponseDto;
import com.bymatt.pruebatecnica.dto.response.menuDto.MenuDto;
import com.bymatt.pruebatecnica.entity.MenuEntity;
import com.bymatt.pruebatecnica.services.MenuServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.bymatt.pruebatecnica.dto.response.StandardResponseDto.GenerateHttpResponse;

@RestController
@RequestMapping("/api/v1/menu")
public class MenuController {
    @Autowired
    private MenuServices menuServices;

    @GetMapping("/list")
    public ResponseEntity<StandardResponseDto> listMenu(@RequestParam(defaultValue = "0") int page,
                                                        @RequestParam(defaultValue = "3") int size ) {
        var servicesResponse = menuServices
                .getAllMenu(PageRequest.of(page, size));
        return GenerateHttpResponse(servicesResponse);
    }

    @PostMapping("/create")
    public ResponseEntity<StandardResponseDto> createMenu(@Valid @RequestBody MenuDto menuDto) {
        var response = menuServices.createMenu(menuDto);
        return GenerateHttpResponse(response);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<StandardResponseDto> listById(@PathVariable Long id) {
        var response = menuServices.getMenuById(id);
        return GenerateHttpResponse(response);
    }
}
