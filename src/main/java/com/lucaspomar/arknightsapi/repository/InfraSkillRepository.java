package com.lucaspomar.arknightsapi.repository;

import com.lucaspomar.arknightsapi.model.InfraSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfraSkillRepository extends JpaRepository<InfraSkill, Long> {
}
