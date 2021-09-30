package com.manage.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.*;

import javax.persistence.*;

@Entity
//@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Tracking extends PanacheEntityBase {
    @Id @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private String status;
}
