package com.fiqrikm18.implemetation_test_1.domain.security;

import lombok.*;
import lombok.experimental.PackagePrivate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AuthenticationResponse {

    private String accessToken;

}
