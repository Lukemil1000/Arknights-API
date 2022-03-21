package com.lucaspomar.arknightsapi.repository;

import com.lucaspomar.arknightsapi.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
}
