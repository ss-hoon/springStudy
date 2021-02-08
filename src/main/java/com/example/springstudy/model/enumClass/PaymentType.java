package com.example.springstudy.model.enumClass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentType {

    CARD(0, "카드", "카드로 결제"),
    CASH(1, "현금", "현금으로 결제")
    ;

    private Integer id;
    private String title;
    private String description;
}
