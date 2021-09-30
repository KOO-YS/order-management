package com.manage;

import com.manage.model.Product;
import com.manage.model.Tracking;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DestinationResource {

    private static final Logger LOG = Logger.getLogger(DestinationResource.class);

    @Channel("to-customer")
    Emitter<Tracking> trackingEmitter;

    @Incoming("out-for-delivery")
    public void delivered(Tracking tracking) {
        tracking.setStatus("Delivery completed (배송 완료)");
        LOG.info(tracking);
        trackingEmitter.send(tracking);
    }
}
