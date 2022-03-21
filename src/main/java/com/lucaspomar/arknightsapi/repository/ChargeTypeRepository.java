package com.lucaspomar.arknightsapi.repository;

import com.lucaspomar.arknightsapi.model.ChargeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChargeTypeRepository extends JpaRepository<ChargeType, Long> {
}
