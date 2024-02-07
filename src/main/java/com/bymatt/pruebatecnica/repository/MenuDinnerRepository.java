package com.bymatt.pruebatecnica.repository;

import com.bymatt.pruebatecnica.entity.MenuDinnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuDinnerRepository extends JpaRepository<MenuDinnerEntity, Long> {
}
