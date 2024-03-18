package com.seet.api.service;

import com.seet.api.model.Usuario;
import com.seet.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
//
//    public Usuario buscarUsuarioPorEmail(String email) {
//        return usuarioRepository.findByEmail(email);
//    }
//
//    public Usuario buscarUsuarioPorNome(String nome) {
//        return usuarioRepository.findByNome(nome);
//    }
}
