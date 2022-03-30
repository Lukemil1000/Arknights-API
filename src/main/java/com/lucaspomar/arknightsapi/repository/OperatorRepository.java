package com.lucaspomar.arknightsapi.repository;

import com.lucaspomar.arknightsapi.model.Operator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatorRepository extends JpaRepository<Operator, Long> {

    Operator findByName(String name);
}
