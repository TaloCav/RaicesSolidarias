package com.equipo3.raicessolidarias.controller;
import com.equipo3.raicessolidarias.dto.LoginDTO;
import com.equipo3.raicessolidarias.dto.RegistroDTO;
import com.equipo3.raicessolidarias.model.ERol;
import com.equipo3.raicessolidarias.model.Rol;
import com.equipo3.raicessolidarias.model.Usuario;
import com.equipo3.raicessolidarias.security.JwtUtils;
import com.equipo3.raicessolidarias.security.UserDetailsImpl;
import com.equipo3.raicessolidarias.service.RolService;
import com.equipo3.raicessolidarias.service.UsuarioServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthRestController {

    private final AuthenticationManager authenticationManager;

    private final UsuarioServiceImpl usuarioService;

    private final RolService rolService;

    private final PasswordEncoder passwordEncoder;

    private final JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginDTO loginRequest) {

        // Autentica al usuario utilizando el gestor de autenticación de Spring Security
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        // Establece la autenticación en el contexto de seguridad de Spring Security
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Obtiene los detalles del usuario autenticado
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        // Genera un token JWT para el usuario autenticado
        String jwtToken = jwtUtils.generateJwtToken(userDetails);

        // Retorna una respuesta exitosa con el token JWT y detalles del usuario
        return new ResponseEntity<>(new JwtResponse(jwtToken, userDetails.getEmail()), HttpStatus.OK);
    }

    @PostMapping("/registro")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegistroDTO solicitudRegistro) {
        // Verifica si el nombre de usuario ya está en uso
        if (usuarioService.existeUsuarioPorEmail(solicitudRegistro.getEmail())) {
            return ResponseEntity.badRequest().body(new String("Error: El username ya está en uso!"));
        }

        // Verifica si el correo electrónico ya está en uso
        if (usuarioService.existeUsuarioPorEmail(solicitudRegistro.getEmail())) {
            return ResponseEntity.badRequest().body(new String("Error: El email ya está en uso"));
        }

        // Crea una nueva cuenta de usuario
        Usuario usuario = Usuario.builder()
                .email(solicitudRegistro.getEmail())
                .password(passwordEncoder.encode(solicitudRegistro.getPassword()))
                .nombre(solicitudRegistro.getNombre()) // Añade nombre
                .apellido(solicitudRegistro.getApellido()) // Añade apellido
                .fechaDeNacimiento(solicitudRegistro.getFechaDeNacimiento())
                .build();

        Set<String> strRoles = solicitudRegistro.getRoles();
        Set<Rol> roles = new HashSet<>();
        if (strRoles == null) {
            Rol rolUsuario = rolService.buscarRolPorNombre(ERol.ROLE_VOLUNTARIO)
                    .orElseThrow(() -> new RuntimeException("Error: Rol no encontrado."));
            roles.add(rolUsuario);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "voluntario":
                        Rol rolVoluntario = rolService.buscarRolPorNombre(ERol.ROLE_VOLUNTARIO)
                                .orElseThrow(() -> new RuntimeException("Error: Rol no encontrado."));
                        roles.add(rolVoluntario);
                        break;
                    case "donante":
                        Rol rolDonante = rolService.buscarRolPorNombre(ERol.ROLE_DONANTE)
                                .orElseThrow(() -> new RuntimeException("Error: Rol no encontrado."));
                        roles.add(rolDonante);
                        break;
                    case "admin":
                        Rol rolAdmin = rolService.buscarRolPorNombre(ERol.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Rol no encontrado."));
                        roles.add(rolAdmin);
                        break;
                    default:
                        Rol rolUsuario = rolService.buscarRolPorNombre(ERol.ROLE_VOLUNTARIO)
                                .orElseThrow(() -> new RuntimeException("Error: Rol no encontrado."));
                        roles.add(rolUsuario);
                }
            });
        }

// Asigna los roles al usuario y guarda el usuario en la base de datos
        usuario.setRoles(roles);
        usuarioService.registrarNuevoUsuario(usuario);

        // Retorna una respuesta exitosa indicando que el usuario se registró correctamente
        return new ResponseEntity(new String("Usuario registrado exitosamente!"), HttpStatus.CREATED);
    }


    // Clase interna que representa la respuesta del token JWT
    @AllArgsConstructor
    @Getter
    @Setter
    public class JwtResponse {
        private String token;
        private String email;
    }
}