package com.example.microservicoDeProfessor.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ProfessorDTO(
        Long id,

        @NotBlank(message = "O nome completo é obrigatório")
        @Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres")
        String nomeCompleto,

        @NotBlank(message = "A escola é obrigatória")
        @Size(min = 3, max = 50, message = "O nome da escola deve ter entre 3 e 50 caracteres")
        String escola
) {}
