package com.manage.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.*;

import javax.persistence.*;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@ToString
public class Product extends PanacheEntityBase {
//public class Product extends PanacheEntityBase {
    @Id @GeneratedValue
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_name")
    private String name;
    @Column(name="product_desc")
    private String description;

}
