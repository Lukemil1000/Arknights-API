package com.lucaspomar.arknightsapi.repository;

import com.lucaspomar.arknightsapi.model.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<Class, Long> {
}
