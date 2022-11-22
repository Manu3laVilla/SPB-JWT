package com.jms.course.jwt.services;

import com.jms.course.jwt.dto.JwtResponse;
import com.jms.course.jwt.dto.UsuarioDTO;
import com.jms.course.jwt.security.JwtIO;
import com.jms.course.jwt.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthService {

    @Autowired
    private JwtIO jwtIO;

    @Autowired
    private DateUtils dateUtils;

    @Value("${jms.jwt.token.expires-in}")
    private int EXPIRES_IN;

    public JwtResponse login(String clientId, String clientSecret){

        UUID uid = UUID.randomUUID();

        UsuarioDTO usuarioDTO = UsuarioDTO.builder()
                .name("Manuela")
                .lastname("Villa")
                .role("Admin")
                .country("Colombia")
                .uid(uid.toString())
                .build();

        JwtResponse jwt = JwtResponse.builder()
                .tokenType("bearer")
                .accessToken(jwtIO.generateToken(usuarioDTO))
                .issuedAt(dateUtils.getDateMilis() + "")
                .clientId(clientId)
                .experisIn(EXPIRES_IN)
                .build();

        return jwt;
    }

}
