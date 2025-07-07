package com.smartjob.controller;

import com.smartjob.dtos.ApiResponse;
import com.smartjob.dtos.LoginUserDTO;
import com.smartjob.dtos.UserRequestDTO;
import com.smartjob.dtos.UserResponseDTO;
import com.smartjob.models.Users;
import com.smartjob.repository.IUsersRepository;
import com.smartjob.security.JwtUtil;
import com.smartjob.service.IUsersService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController {


    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    IUsersRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtil jwtUtils;

    @Autowired
    IUsersService service;

    @Autowired
    ModelMapper modelMapper;


    @PostMapping("/login") //loguearse
    public ResponseEntity<?> authenticateUser(@RequestBody LoginUserDTO user) {

        List<String> errors = new ArrayList<>();

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            String jwt = jwtUtils.generateToken(String.valueOf(authentication));
            return ResponseEntity.ok(jwt);

        } catch (AuthenticationCredentialsNotFoundException e) {
            errors.add("Usuario no encontrado.");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errors);
        } catch (BadCredentialsException e) {
            errors.add("Credenciales inválidas.");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errors);
        }
    }


    @PostMapping("/registro") //registro
    public ResponseEntity<?> save(@RequestBody UserRequestDTO dto) throws Exception {

        List<String> errors = new ArrayList<>();

        /*if (!validator.isValidEmail(dto.getEmail())) {
            errors.add("El formato del email no válido.");
        }*/

        if (userRepository.existsByUsername(dto.getUsername())) {
            errors.add("El nombre de usuario ya existe.");
        }

        if (userRepository.existsByEmail(dto.getEmail())) {
            errors.add("El correo ya está registrado.");
        }

        if (!errors.isEmpty()) {
            ApiResponse errorResponse = new ApiResponse(errors);
            return ResponseEntity.badRequest().body(errorResponse);
        }

        dto.setPassword(encoder.encode(dto.getPassword()));

        Users u = service.save(modelMapper.map(dto, Users.class));
        UserResponseDTO userDTO = modelMapper.map(u, UserResponseDTO.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
    }

    @PostMapping("/todos")
    public ResponseEntity<?> findall() throws Exception {

        List<String> errors = new ArrayList<>();

        List<UserResponseDTO> u = service.findall()
                .stream()
                .map(this::convertToDto)
                .toList();

        if (u.isEmpty()) {
            errors.add("No existen registros para mostrar.");
            ApiResponse errorResponse = new ApiResponse(errors);
            return ResponseEntity.ok().body(errorResponse);
        }

        return ResponseEntity.status(HttpStatus.OK).body(u);
    }

    private UserResponseDTO convertToDto(Users obj) {
        return modelMapper.map(obj, UserResponseDTO.class);
    }

    private Users convertToEntity(UserResponseDTO dto) {
        return modelMapper.map(dto, Users.class);
    }


}