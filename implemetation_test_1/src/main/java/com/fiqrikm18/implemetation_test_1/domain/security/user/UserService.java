package com.fiqrikm18.implemetation_test_1.domain.security.user;

import com.fiqrikm18.implemetation_test_1.domain.security.RegisterRequest;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public UserInfo save(RegisterRequest request) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = request.getPassword();
        String encodedPassword = encoder.encode(rawPassword);

        UserInfo userInfo = UserInfo.builder()
                .username(request.getUsername())
                .password(encodedPassword)
                .role(request.getUserRole())
                .build();

        return userRepository.save(userInfo);
    }

}
