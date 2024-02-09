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

    public StandardResponseDto getMenuById(long id) {
        var menuEntity = menuRepository.findById(id);
        if (menuEntity.isEmpty()) {
            return  new StandardResponseDto(HttpStatus.NOT_FOUND);
        }
        return new StandardResponseDto(HttpStatus.OK, menuEntity.get());
    }

    public StandardResponseDto createMenu(MenuDto menuDto) {
            var save = menuRepository.save(new MenuEntity(menuDto));
            return new StandardResponseDto(HttpStatus.CREATED, save);
    }
}
