package com.fiqrikm18.implemetation_test_1.domain.security.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long> {
    public UserInfo findByUsername(String username);
}
