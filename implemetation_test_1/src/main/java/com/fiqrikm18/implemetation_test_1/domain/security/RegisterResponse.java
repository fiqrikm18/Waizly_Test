package com.fiqrikm18.implemetation_test_1.domain.security;

import com.fiqrikm18.implemetation_test_1.domain.security.user.UserRole;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterResponse {
    private String username;
    private UserRole roles;
}
