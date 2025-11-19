package com.example.microservicoDeProfessor.model.validation;

import com.example.microservicoDeProfessor.dto.ProfessorDTO;
import org.springframework.stereotype.Component;

@Component
public class ProfessorValidation {

        public void validar(ProfessorDTO dto) {
            validarNome(dto.nomeCompleto());
            validarEscola(dto.escola());
        }

        private void validarNome(String nome) {
            if (nome == null || nome.trim().isEmpty()) {
                throw new IllegalArgumentException("Nome do professor não pode ser vazio.");
            }

            if (!nome.trim().contains(" ")) {
                throw new IllegalArgumentException("Informe o nome e sobrenome do professor.");
            }
        }

        private void validarEscola(String escola) {
            if (escola == null || escola.trim().isEmpty()) {
                throw new IllegalArgumentException("Escola não pode ser vazia.");
            }

            if (escola.length() < 3) {
                throw new IllegalArgumentException("Nome da escola muito curto.");
            }

            if (escola.matches("[0-9]+")) {
                throw new IllegalArgumentException("Nome da escola inválido (não pode ser apenas números).");
            }
        }
    }