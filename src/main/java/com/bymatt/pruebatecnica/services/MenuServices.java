package com.bymatt.pruebatecnica.services;

import com.bymatt.pruebatecnica.dto.response.StandardResponseDto;
import com.bymatt.pruebatecnica.dto.response.menuDto.MenuDto;
import com.bymatt.pruebatecnica.entity.MenuEntity;
import com.bymatt.pruebatecnica.repository.MenuRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MenuServices {
    @Autowired
    private MenuRepository menuRepository;

    public StandardResponseDto getAllMenu(PageRequest pageable) {
        var list = menuRepository.findAll(pageable);
        return new StandardResponseDto(HttpStatus.OK, list);
    }

    public StandardResponseDto getMenuById() {
        return null;
    }

    public StandardResponseDto createMenu(MenuDto menuDto) {
        try {
            var menuEntity = MenuEntity.builder().name(menuDto.getName()).price(menuDto.getPrice()).state(menuDto.getState()).build();
            var save = menuRepository.save(menuEntity);
            return new StandardResponseDto(HttpStatus.OK, save);
        } catch (Exception e) {
            return new StandardResponseDto(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
