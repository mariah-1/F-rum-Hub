package com.example.forum.domain.topico.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TopicoRequest {
    @NotBlank
    private String titulo;

    @NotBlank
    private String mensagem;

    @NotBlank
    private String nomeCurso;
}
