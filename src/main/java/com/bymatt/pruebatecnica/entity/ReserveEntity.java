package com.bymatt.pruebatecnica.entity;

import com.bymatt.pruebatecnica.dto.response.reserveDto.ReserveDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reserve")
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

    public ReserveEntity(ReserveDto reserveDto) {
        this.customerName = reserveDto.getCustomerName();
        this.customerNumber = reserveDto.getCustomerNumber();
        this.dateReserve = new Date();
        this.state = reserveDto.getState();
    }


    public ReserveEntity(Long id, ReserveDto reserveDto) {
        this.idReserve = id;
        this.customerName = reserveDto.getCustomerName();
        this.customerNumber = reserveDto.getCustomerNumber();
        this.dateReserve = new Date();
        this.state = reserveDto.getState();
        this.idMenu = MenuEntity.builder().idMenu(reserveDto.getIdMenu()).build();
    }
}
