package com.manage;

import com.manage.model.Product;
import com.manage.model.Tracking;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SortingResource {

    private static final Logger LOG = Logger.getLogger(SortingResource.class);

    @Channel("out-for-delivery")
    Emitter<Product> deliveryEmitter;

    @Channel("to-customer")
    Emitter<Tracking> trackingEmitter;

    @Incoming("shipped")
    public void shipped(Product product) throws InterruptedException {
        System.out.println("comfirm shipping form shop -> "+product);
        for(int i=5; i>0; i--) {
            Thread.sleep(1000);
//            LOG.info("start shipping "+i+" seconds after...");
        }
        Tracking tracking = Tracking
                .builder()
                .id(product.getId()).product(product).status("out for delivery (최종 배송지로 발송)")
                .build();
        deliveryEmitter.send(product);
        trackingEmitter.send(tracking);
        LOG.info(tracking);
    }
}