package com.example.springboot.services;

import com.example.springboot.model.Usuario;
import com.example.springboot.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
//
//
//
//import java.util.List;
//
//@Service
//
//public class UsuarioService {
//
//
//    @Autowired
//    private UsuarioRepository usuarioRepository;
//
//    // CREATE
//    public Usuario criarUsuario(Usuario usuario) {
//        return usuarioRepository.save(usuario);
//    }
//
//    // READ - todos
//    public List<Usuario> listarUsuarios() {
//        return usuarioRepository.findAll();
//    }
//
//    // READ - por ID
//    public Usuario buscarPorId(Long id) {
//        return usuarioRepository.findById(id).orElse(null);
//    }
//
//    // UPDATE
//    public Usuario atualizarUsuario(Long id, Usuario novoUsuario) {
//        return usuarioRepository.findById(id).map(usuario -> {
//            usuario.setNome(novoUsuario.getNome());
//            usuario.setEmail(novoUsuario.getEmail());
//            usuario.setSenhaHash(novoUsuario.getSenhaHash());
//            return usuarioRepository.save(usuario);
//        }).orElse(null);
//    }
//
//    // DELETE
//    public void deletarUsuario(Long id) {
//        usuarioRepository.deleteById(id);
//    }
//}
//
//


import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // CREATE
    public Usuario criarUsuario(Usuario usuario) {
        // Validação customizada: checar se o email já existe
        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "E-mail já cadastrado");
        }

        // Em um projeto real, a senha deveria ser criptografada aqui
        return usuarioRepository.save(usuario);
    }

    // READ ALL
    public List<Usuario> buscarTodos() {
        // Nota: Ao retornar a entidade diretamente, a senha será exposta.
        // Isso é uma desvantagem de não usar DTOs.
        return usuarioRepository.findAll();
    }

    // READ BY ID
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado com ID: " + id));
    }

    // UPDATE
    public Usuario atualizarUsuario(Long id, Usuario dadosNovos) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado com ID: " + id));

        // Validação de e-mail para evitar duplicidade
        if (!usuarioExistente.getEmail().equals(dadosNovos.getEmail()) && usuarioRepository.findByEmail(dadosNovos.getEmail()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "E-mail já cadastrado por outro usuário");
        }

        usuarioExistente.setNome(dadosNovos.getNome());
        usuarioExistente.setEmail(dadosNovos.getEmail());
        usuarioExistente.setSenha(dadosNovos.getSenha()); // Atualiza a senha

        return usuarioRepository.save(usuarioExistente);
    }

    // DELETE
    public void deletarUsuario(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado com ID: " + id);
        }
        usuarioRepository.deleteById(id);
    }


    public Usuario autenticar(String email, String senha) {
        // 1. Busca o usuário pelo email
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Credenciais inválidas.")); // 401 Unauthorized

        // 2. Verifica a senha (Em um projeto real, usaria BCryptPasswordEncoder!)
        if (!usuario.getSenha().equals(senha)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Credenciais inválidas.");
        }

        // Sucesso na autenticação
        return usuario;
    }
}