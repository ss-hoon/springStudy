package com.example.springstudy.model.network;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Header<T> {

    // 일반적으로 통신을 할 때는 데이터 타입을 String으로 한다.
    // api 통신 시간
    private String transactionTime;

    // api 응답 코드
    private String resultCode;

    // api 부가 설명
    private String description;

    private T data;
}
