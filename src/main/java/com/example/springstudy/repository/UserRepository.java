package com.example.springstudy.repository;

import com.example.springstudy.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> { // 객체타입, 기본키

    User findFirstByPhoneNumberOrderByIdDesc(String phoneNumber);
}
