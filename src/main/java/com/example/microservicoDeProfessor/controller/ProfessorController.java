package com.example.microservicoDeProfessor.controller;

import com.example.microservicoDeProfessor.dto.ProfessorDTO;
import com.example.microservicoDeProfessor.model.entity.Professor;
import com.example.microservicoDeProfessor.model.service.ProfessorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @PostMapping
    public ResponseEntity<Professor> create(@RequestBody @Valid ProfessorDTO dto) {
        return ResponseEntity.ok(professorService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professor> update(@PathVariable Long id, @RequestBody @Valid ProfessorDTO dto) {
        return ResponseEntity.ok(professorService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        professorService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> findById(@PathVariable Long id) {
        return ResponseEntity.ok(professorService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Professor>> findAll() {
        return ResponseEntity.ok(professorService.findAll());
    }

    @GetMapping("/exists/{id}")
    public Boolean existsId(@PathVariable Long id) {
        return professorService.existsId(id);
    }
}
