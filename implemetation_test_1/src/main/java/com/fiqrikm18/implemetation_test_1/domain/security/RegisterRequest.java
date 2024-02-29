package com.fiqrikm18.implemetation_test_1.domain.security;

import com.fiqrikm18.implemetation_test_1.domain.security.user.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String username;
    private String password;
    private UserRole userRole;
}
