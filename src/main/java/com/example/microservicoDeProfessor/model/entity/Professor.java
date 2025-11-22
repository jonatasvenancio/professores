package com.example.microservicoDeProfessor.model.entity;

import com.example.microservicoDeProfessor.dto.ProfessorDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tb_professores")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeCompleto;

    @Column(nullable = false)
    private String escola;

    public Professor() {

    }

    public Professor(ProfessorDTO dto) {
        this.id = dto.id();
        this.nomeCompleto = dto.nomeCompleto();
        this.escola = dto.escola();
    }
}
