package com.example.microservicoDeProfessor.model.repository;

import com.example.microservicoDeProfessor.model.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}