package com.test.yourself.authentification.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {

    private String jwt;

    private Long id;

    private String email;

    private List<String> roles = new ArrayList<>();

}
