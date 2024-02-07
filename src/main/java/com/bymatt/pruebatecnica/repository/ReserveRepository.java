package com.bymatt.pruebatecnica.repository;

import com.bymatt.pruebatecnica.entity.ReserveEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReserveRepository extends JpaRepository<ReserveEntity, Long> {
}
