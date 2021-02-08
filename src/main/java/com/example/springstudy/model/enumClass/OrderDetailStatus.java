package com.example.springstudy.model.enumClass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderDetailStatus {

    COMPLETE(0, "완료", "상품을 준비한 상태"),
    WAITING(1, "준비중", "상품을 준비중인 상태")
    ;

    private Integer id;
    private String title;
    private String description;
}
