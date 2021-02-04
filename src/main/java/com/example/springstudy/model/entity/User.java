package com.example.springstudy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity // == table
// @Table(name="user") 테이블의 이름이 동일하면 생략 가능
public class User {
    // @Column(name="id") 컬럼의 이름이 동일하면 생략 가능
    @Id // 식별자
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 전략 옵션
    private Long id;

    private String account;

    private String password;

    private String status;

    private String email;

    private String phoneNumber;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;
}
