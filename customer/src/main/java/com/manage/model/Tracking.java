package com.manage.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.mongodb.panache.PanacheMongoEntityBase;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.*;
import org.bson.codecs.pojo.annotations.BsonId;

import javax.persistence.*;

@Entity
//@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@ToString
public class Tracking extends PanacheEntityBase {

//    @BsonId
    @Id @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private String status;
}
