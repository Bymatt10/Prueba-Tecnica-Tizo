package com.bymatt.pruebatecnica.dto.response.menuDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class MenuDto {
    private  Long id;

    @NotBlank(message = "Name can't be null")
    private String name;

    @NotNull(message = "Double can't be null")
    @Size(message = "The price can't be lower than 0 ")
    private Double price;

    @NotNull(message = "State can't not be null")
    private Boolean state;
}
