package com.fiqrikm18.implemetation_test_1.domain.security;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AuthenticationRequest {

    private String username;
    private String password;

}
