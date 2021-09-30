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
    Emitter<Tracking> deliveryEmitter;

    @Channel("to-customer")
    Emitter<Tracking> trackingEmitter;

    @Incoming("shipped")
    public void shipped(Tracking tracking) throws InterruptedException {
        LOG.info("Wait for 5 seconds");
        Thread.sleep(5000);
//            LOG.info("start shipping "+i+" seconds after...");
        tracking.setStatus("out for delivery (최종 배송지로 발송)");
        LOG.info(tracking);
        deliveryEmitter.send(tracking);
        trackingEmitter.send(tracking);
    }
}