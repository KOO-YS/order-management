package com.manage.resource;

import com.manage.model.Tracking;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.mongodb.panache.PanacheMongoRepositoryBase;

public interface TrackingMongoRepository extends PanacheMongoRepositoryBase<Tracking, Long> {
}
