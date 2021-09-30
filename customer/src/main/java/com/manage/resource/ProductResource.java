package com.manage.resource;

import com.manage.model.Product;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;

public interface ProductResource extends PanacheEntityResource<Product, Long> {
}
