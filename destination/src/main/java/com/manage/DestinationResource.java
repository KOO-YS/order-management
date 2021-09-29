package com.manage;

import com.manage.model.Product;
import com.manage.model.Tracking;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DestinationResource {

    @Channel("to-customer")
    Emitter<Tracking> trackingEmitter;

    @Incoming("out-for-delivery")
    public void delivered(Product product) {
        System.out.println("delivered well -> "+product);
        Tracking tracking = Tracking
                .builder()
                .id(product.getId()).product(product).status("Delivery completed (배송 완료)")
                .build();
        trackingEmitter.send(tracking);
    }
}
