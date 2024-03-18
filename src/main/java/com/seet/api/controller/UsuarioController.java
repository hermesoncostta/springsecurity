package com.seet.api.controller;

import com.seet.api.model.Usuario;
import com.seet.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    /*@PostMapping
    public ResponseEntity<?> criarUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioExistente = usuarioService.buscarUsuarioPorEmail(usuario.getEmail());
        if (usuarioExistente != null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Erro: Já existe um usuário com este e-mail.");
        }

        usuarioExistente = usuarioService.buscarUsuarioPorNome(usuario.getNome());
        if (usuarioExistente != null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Erro: Já existe um usuário com este nome.");
        }
        Usuario novoUsuario = usuarioService.criarUsuario(usuario);
        return new ResponseEntity<>(novoUsuario, HttpStatus.OK);
    }*/
}
