package com.lucaspomar.arknightsapi.repository;

import com.lucaspomar.arknightsapi.model.Subclass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubclassRepository extends JpaRepository<Subclass, Long> {
}
