package com.bymatt.pruebatecnica.entity;

import com.bymatt.pruebatecnica.dto.response.menuDto.MenuDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "menu")
public class MenuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_menu")
    private Long idMenu;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "state")
    private Boolean state;

    public MenuEntity(MenuDto menuDto) {
        this.idMenu = menuDto.getId();
        this.name = menuDto.getName();
        this.price = menuDto.getPrice();
        this.state = menuDto.getState();
    }
}

