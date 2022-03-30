package com.lucaspomar.arknightsapi.repository;

import com.lucaspomar.arknightsapi.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {

    Skill findByName(String name);
}
