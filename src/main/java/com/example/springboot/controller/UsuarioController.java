package com.example.springboot.controller;

import com.example.springboot.model.Usuario;
import com.example.springboot.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

//
//import java.util.List;
//
//@RestController
//@RequestMapping("/usuarios")
//@CrossOrigin("*")
//
//public class UsuarioController {
//
//    private final UsuarioRepository usuarioRepository;
//
//    public UsuarioController(UsuarioRepository usuarioRepository) {
//        this.usuarioRepository = usuarioRepository;
//    }
//
//    @GetMapping
//    public List<Usuario> listar() {
//        return usuarioRepository.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Usuario> buscar(@PathVariable Long id) {
//        return usuarioRepository.findById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @PostMapping
//    public ResponseEntity<Usuario> criar(@RequestBody Usuario usuario) {
//        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
//            return ResponseEntity.badRequest().body(null);
//        }
//        return ResponseEntity.ok(usuarioRepository.save(usuario));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
//        return usuarioRepository.findById(id).map(u -> {
//            usuario.setId(id);
//            return ResponseEntity.ok(usuarioRepository.save(usuario));
//        }).orElse(ResponseEntity.notFound().build());
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deletar(@PathVariable Long id) {
//        if (!usuarioRepository.existsById(id))
//            return ResponseEntity.notFound().build();
//
//        usuarioRepository.deleteById(id);
//        return ResponseEntity.noContent().build();
//    }
//}





import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // POST: /api/usuarios
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario criarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.criarUsuario(usuario);
    }

    // POST: /api/usuarios/login
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public Usuario fazerLogin(@RequestBody Usuario usuarioLogin) {

        return usuarioService.autenticar(usuarioLogin.getEmail(), usuarioLogin.getSenha());
    }

    // GET: /api/usuarios
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> listarUsuarios() {
        return usuarioService.buscarTodos();
    }

    // GET: /api/usuarios/{id}
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Usuario buscarUsuarioPorId(@PathVariable Long id) {
        return usuarioService.buscarPorId(id);
    }

    // PUT: /api/usuarios/{id}
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Usuario atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        return usuarioService.atualizarUsuario(id, usuario);
    }

    // DELETE: /api/usuarios/{id}
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
    }
}
