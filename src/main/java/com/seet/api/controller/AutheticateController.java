package com.seet.api.controller;

import com.seet.api.dto.AuthenticationDTO;
import com.seet.api.dto.RegisterDTO;
import com.seet.api.infra.security.DataToken;
import com.seet.api.infra.security.TokenService;
import com.seet.api.model.Usuario;
import com.seet.api.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.AuthenticationException;


@RestController
@RequestMapping("/auth")
public class AutheticateController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private TokenService tokenService;


    @PostMapping("/login")
    public ResponseEntity efetuarLogin(@RequestBody @Valid AuthenticationDTO dados) {
        try {
            var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
            var authentication = authenticationManager.authenticate(authenticationToken);

            var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

            return ResponseEntity.ok(new DataToken(tokenJWT));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterDTO data) {
//        if (this.usuarioRepository.findByEmail(data.email()) != null) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já registrado.");
//        }
        String senhaEncripted = passwordEncoder.encode(data.senha());
        Usuario novoUsuario = new Usuario(data.login(), senhaEncripted);
        this.usuarioRepository.save(novoUsuario);
        return ResponseEntity.ok().build();
    }
}

