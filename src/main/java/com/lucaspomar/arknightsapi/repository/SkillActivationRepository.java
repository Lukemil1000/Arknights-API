package com.lucaspomar.arknightsapi.repository;

import com.lucaspomar.arknightsapi.model.SkillActivation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillActivationRepository extends JpaRepository<SkillActivation, Long> {

    SkillActivation findByName(String name);
}
