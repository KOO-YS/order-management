package com.manage.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Tracking {
    private Long id;
    private Product product;
    private String status;

    public void setStatus(String status) {
        this.status = status;
    }
}