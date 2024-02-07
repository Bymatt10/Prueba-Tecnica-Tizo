package com.bymatt.pruebatecnica.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Reserve")
public class ReserveEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserve")
    private Long idReserve;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(name = "customer_number", nullable = false)
    private String customerNumber;

    @Column(name = "date_reserve", nullable = false)
    private Date dateReserve;

    @Column(name = "state")
    private Boolean state;

    @OneToOne(targetEntity = MenuEntity.class)
    @JoinColumn(name = "id_menu", referencedColumnName = "id_menu", insertable = false, updatable = false)
    private MenuEntity idMenu;
}
