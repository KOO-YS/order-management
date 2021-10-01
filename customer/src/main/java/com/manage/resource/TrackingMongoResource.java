package com.manage.resource;

import com.manage.model.Tracking;
import io.quarkus.mongodb.rest.data.panache.PanacheMongoRepositoryResource;


public interface TrackingMongoResource extends PanacheMongoRepositoryResource<TrackingMongoRepository, Tracking, Long> {

}
