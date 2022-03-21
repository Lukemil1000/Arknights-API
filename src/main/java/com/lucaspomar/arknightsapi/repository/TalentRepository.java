package com.lucaspomar.arknightsapi.repository;

import com.lucaspomar.arknightsapi.model.Talent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TalentRepository extends JpaRepository<Talent, Long> {
}
