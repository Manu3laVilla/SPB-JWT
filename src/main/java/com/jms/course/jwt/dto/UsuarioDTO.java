package com.jms.course.jwt.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class UsuarioDTO implements Serializable {

    private String uid;
    private String name;
    private String lastname;
    private String role;
    private String country;

}
