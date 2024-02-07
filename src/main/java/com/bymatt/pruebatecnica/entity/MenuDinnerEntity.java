package com.bymatt.pruebatecnica.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "MenuDinner")
public class MenuDinnerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_dinner", referencedColumnName = "id_dinner", insertable = false, updatable = false)
    private DinnerEntity dinner;

    @OneToMany(targetEntity = MenuEntity.class)
    @Column(name = "id_menu")
    private List<MenuEntity> menu;

}

