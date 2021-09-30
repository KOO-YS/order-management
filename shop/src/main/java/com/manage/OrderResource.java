package com.manage;

import com.manage.model.Product;
import com.manage.model.Tracking;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import java.util.Random;

@ApplicationScoped
public class OrderResource {

    private static final Logger LOG = Logger.getLogger(OrderResource.class);

    @Channel("shipped")
    Emitter<Product> shipEmitter;

    @Channel("to-customer")
    Emitter<Tracking> trackingEmitter;

    @Incoming("order-product")
    public void process(Product product) throws InterruptedException {
        System.out.println("confirm order for "+product);
        int random = new Random().nextInt(10);
        for(int i=random; i>0; i--) {
            Thread.sleep(1000);
//            System.out.println("finish packaging "+i+" seconds after...");
        }
        Tracking tracking = Tracking.builder().product(product).status("Package and Send Product (포장 후 발송 시작)").build();
        trackingEmitter.send(tracking);
        shipEmitter.send(product);
    }

}
