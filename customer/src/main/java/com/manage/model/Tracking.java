package com.manage.model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Tracking {
    private Long id;
    private Product product;
    private String status;
}
