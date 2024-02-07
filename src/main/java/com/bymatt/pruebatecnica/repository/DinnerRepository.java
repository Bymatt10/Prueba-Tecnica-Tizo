package com.bymatt.pruebatecnica.repository;

import com.bymatt.pruebatecnica.entity.DinnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DinnerRepository extends JpaRepository<DinnerEntity, Long> {
}
