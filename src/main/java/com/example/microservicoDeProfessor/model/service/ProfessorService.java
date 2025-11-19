package com.example.microservicoDeProfessor.model.service;

import com.example.microservicoDeProfessor.dto.ProfessorDTO;
import com.example.microservicoDeProfessor.model.entity.Professor;
import com.example.microservicoDeProfessor.model.excepition.RecursoNaoEncontradoException;
import com.example.microservicoDeProfessor.model.repository.ProfessorRepository;
import com.example.microservicoDeProfessor.model.validation.ProfessorValidation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final ProfessorValidation professorValidation;

    public ProfessorService(ProfessorRepository professorRepository, ProfessorValidation professorValidation) {
        this.professorRepository = professorRepository;
        this.professorValidation = professorValidation;
    }

    public Professor findById(Long id) {
        return professorRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Professor com ID " + id + " não encontrado."));
    }

    public Professor create(ProfessorDTO dto) {
        professorValidation.validar(dto);

        return professorRepository.save(new Professor(dto));
    }

    public Professor update(Long id, ProfessorDTO dto) {
        Professor professor = findById(id);

        professorValidation.validar(dto);

        professor.setNomeCompleto(dto.nomeCompleto());
        professor.setEscola(dto.escola());

        return professorRepository.save(professor);
    }

    public void delete(Long id) {
        Professor professor = findById(id);
        professorRepository.delete(professor);
    }

    public List<Professor> findAll() {
        return professorRepository.findAll();
    }
}