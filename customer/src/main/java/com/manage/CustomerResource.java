package com.manage;

import com.manage.model.Product;
import com.manage.model.Tracking;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/customer/order")
public class CustomerResource {

    private static final Logger LOG = Logger.getLogger(CustomerResource.class);


    @Channel("order-product")
    Emitter<Product> productEmitter;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }

    @POST
    public Response orderProduct(Product product) {
        // refs -> https://quarkus.io/guides/resteasy-reactive#returning-a-response-body
        productEmitter.send(product);

        return Response.ok().entity(product).build();
    }

    @Incoming("to-customer")
    public void getTrackingStatus(Tracking tracking) {
        System.out.println("DELIVERY STATUS :: "+tracking);
    }
}