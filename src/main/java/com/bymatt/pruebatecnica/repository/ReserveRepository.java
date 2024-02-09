package com.bymatt.pruebatecnica.repository;

import com.bymatt.pruebatecnica.entity.ReserveEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ReserveRepository extends JpaRepository<ReserveEntity, Long> {
    @Transactional
    @Modifying
    @Query(value = "insert into reserve(customer_name, customer_number, date_reserve, state, id_menu ) values(?,?,?,?,?)", nativeQuery = true)
    void createNewReserve(String customerName, String customerNumber, Date dateReserve, Boolean state, Long idMenu);
}
