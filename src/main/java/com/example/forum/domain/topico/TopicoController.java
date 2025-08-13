package com.example.forum.domain.topico;

import com.example.forum.domain.topico.dto.TopicoRequest;
import com.example.forum.domain.topico.dto.TopicoResponse;
import com.example.forum.repository.CursoRepository;
import com.example.forum.repository.TopicoRepository;
import com.example.forum.repository.UsuarioRepository;
import com.example.forum.usuario.Usuario;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoRepository topicoRepository;
    private final UsuarioRepository usuarioRepository;
    private final CursoRepository cursoRepository;

    public TopicoController(TopicoRepository topicoRepository, UsuarioRepository usuarioRepository, CursoRepository cursoRepository) {
        this.topicoRepository = topicoRepository;
        this.usuarioRepository = usuarioRepository;
        this.cursoRepository = cursoRepository;
    }

    @GetMapping
    public List<TopicoResponse> listar() {
        return topicoRepository.findAll().stream().map(TopicoResponse::of).toList();
    }

    @PostMapping
    public TopicoResponse criar(@RequestBody @Valid TopicoRequest req) {
        Usuario autor = usuarioRepository.findAll().stream().findFirst()
                .orElseGet(() -> {
                    Usuario u = new Usuario();
                    u.setNome("Anônimo");
                    return usuarioRepository.save(u);
                });

        var curso = cursoRepository.findByNomeIgnoreCase(req.getNomeCurso())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Curso não encontrado: " + req.getNomeCurso()));

        Topico novo = new Topico();
        novo.setTitulo(req.getTitulo());
        novo.setMensagem(req.getMensagem());
        novo.setAutor(autor);
        novo.setCurso(curso);

        novo = topicoRepository.save(novo);
        return TopicoResponse.of(novo);
    }

    @PutMapping("/{id}")
    public TopicoResponse atualizar(@PathVariable Long id, @RequestBody @Valid TopicoRequest req) {
        var topico = topicoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tópico não encontrado"));

        topico.setTitulo(req.getTitulo());
        topico.setMensagem(req.getMensagem());
        topicoRepository.save(topico);
        return TopicoResponse.of(topico);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        if (!topicoRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tópico não encontrado");
        }
        topicoRepository.deleteById(id);
    }
}
