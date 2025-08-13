package com.example.forum.domain.topico;

import com.example.forum.usuario.Usuario;
import com.example.forum.domain.curso.Curso;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Topico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false, length = 2000)
    private String mensagem;

    @ManyToOne(optional = false)
    private Usuario autor;

    @ManyToOne(optional = false)
    private Curso curso;
}
