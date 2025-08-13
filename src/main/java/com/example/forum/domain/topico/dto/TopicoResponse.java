package com.example.forum.domain.topico.dto;

import com.example.forum.domain.topico.Topico;
import lombok.Data;

@Data
public class TopicoResponse {
    private Long id;
    private String titulo;
    private String mensagem;
    private String autor;
    private String curso;

    public TopicoResponse(Long id, String titulo, String mensagem, String autor, String curso) {
        this.id = id;
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.autor = autor;
        this.curso = curso;
    }

    public static TopicoResponse of(Topico t) {
        return new TopicoResponse(t.getId(), t.getTitulo(), t.getMensagem(),
                t.getAutor().getNome(), t.getCurso().getNome());
    }
}
