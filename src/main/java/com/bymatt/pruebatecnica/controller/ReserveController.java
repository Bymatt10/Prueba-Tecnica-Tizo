package com.bymatt.pruebatecnica.controller;

import com.bymatt.pruebatecnica.dto.response.StandardResponseDto;
import com.bymatt.pruebatecnica.dto.response.reserveDto.ReserveDto;
import com.bymatt.pruebatecnica.services.ReserveServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.bymatt.pruebatecnica.dto.response.StandardResponseDto.GenerateHttpResponse;

@RestController
@RequestMapping("/api/v1/reserve")
public class ReserveController {
    @Autowired
    private ReserveServices reserveServices;


    @GetMapping("/list")
    public ResponseEntity<StandardResponseDto> listReserve(@RequestParam(defaultValue = "0") int page,
                                                           @RequestParam(defaultValue = "3") int size) {
        var response = reserveServices.getAllServices(PageRequest.of(page,size));
        return GenerateHttpResponse(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StandardResponseDto> getReserveById(@PathVariable Long id) {
        var response = reserveServices.getReserveById(id);
        return GenerateHttpResponse(response);
    }

    @PostMapping("/create")
    public ResponseEntity<StandardResponseDto> createReserve(@RequestBody @Valid ReserveDto reserveDto) {
        var response = reserveServices.createReserve(reserveDto);
        return GenerateHttpResponse(response);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<StandardResponseDto> updateReserve(@RequestBody @Valid ReserveDto reserveDto, @PathVariable Long id) {
        var response = reserveServices.updateReserve(id, reserveDto);
        return GenerateHttpResponse(response);
    }


    @PostMapping("/cancel/{id}")
    public ResponseEntity<StandardResponseDto> cancelReserve(@PathVariable Long id) {
        var response = reserveServices.cancelReserve(id);
        return GenerateHttpResponse(response);
    }
}
