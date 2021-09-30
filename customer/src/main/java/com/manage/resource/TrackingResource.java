package com.manage.resource;

import com.manage.model.Tracking;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;

public interface TrackingResource extends PanacheEntityResource<Tracking, Long> {
}
