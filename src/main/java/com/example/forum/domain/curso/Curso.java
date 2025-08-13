package com.example.forum.domain.curso;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Curso {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String nome;
}
