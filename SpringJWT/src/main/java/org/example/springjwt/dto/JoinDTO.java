package org.example.springjwt.dto;

import jakarta.persistence.GeneratedValue;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoinDTO {

    private String username;
    private String password;
    private String email;
    private String phone;

}
