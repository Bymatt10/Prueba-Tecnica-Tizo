package com.bymatt.pruebatecnica.services;

import com.bymatt.pruebatecnica.dto.response.StandardResponseDto;
import com.bymatt.pruebatecnica.dto.response.reserveDto.ReserveDto;
import com.bymatt.pruebatecnica.entity.ReserveEntity;
import com.bymatt.pruebatecnica.repository.ReserveRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class ReserveServices {
    @Autowired
    private ReserveRepository reserveRepository;

    public StandardResponseDto getAllServices(PageRequest pageRequest) {
        var list = reserveRepository.findAll(pageRequest);
        return new StandardResponseDto(HttpStatus.OK, list);
    }

    public StandardResponseDto createReserve(ReserveDto reserveDto) {
        reserveRepository.createNewReserve(reserveDto.getCustomerName(), reserveDto.getCustomerNumber(), new Date(), reserveDto.getState(), reserveDto.getIdMenu());
        return new StandardResponseDto(HttpStatus.OK, reserveDto);
    }

    public StandardResponseDto updateReserve(long id, ReserveDto reserveDto) {
        var searchEntity = reserveRepository.findById(id);
        if (searchEntity.isEmpty()) {
            return new StandardResponseDto(HttpStatus.NOT_FOUND);
        }
        var updateReserve = reserveRepository.save(new ReserveEntity(id, reserveDto));
        return new StandardResponseDto(HttpStatus.OK, updateReserve);
    }

    public StandardResponseDto getReserveById(long id) {
        var searchEntity = reserveRepository.findById(id);
        if (searchEntity.isEmpty()) {
            return new StandardResponseDto(HttpStatus.NOT_FOUND);
        }
        return new StandardResponseDto(HttpStatus.OK, searchEntity.get());
    }

    public StandardResponseDto cancelReserve(Long id) {
        var disable = reserveRepository.findById(id);
        if (disable.isPresent()) {
            disable.get().setState(false);
            reserveRepository.save(disable.get());
            return new StandardResponseDto(HttpStatus.OK);
        }
        return new StandardResponseDto(HttpStatus.NOT_FOUND);
    }
}
