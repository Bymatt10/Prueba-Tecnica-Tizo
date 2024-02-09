package com.bymatt.pruebatecnica.dto.response.reserveDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReserveDto {

    @NotBlank(message = "Customer Name can't be null ")
    private String customerName;

    @NotBlank(message = "Customer Number can't be null ")
    private String customerNumber;

    @NotNull(message = "Customer Name can't be null ")
    private Boolean state;

    @NotNull(message = "Menu Id can't be null")
    private  Long idMenu;
}
