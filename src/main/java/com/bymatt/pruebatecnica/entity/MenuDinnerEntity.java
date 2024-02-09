package com.bymatt.pruebatecnica.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "menu_dinner")
public class MenuDinnerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_dinner", referencedColumnName = "id_dinner", insertable = false, updatable = false)
    private DinnerEntity dinner;

    @ManyToOne(targetEntity = MenuEntity.class)
    @JoinColumn(name = "id_menu")
    private MenuEntity menuuuuuu;

}

