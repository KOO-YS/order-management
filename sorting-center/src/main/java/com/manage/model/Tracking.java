package com.manage.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Tracking {
    private Long id;
    private Product product;
    private String status;
}
