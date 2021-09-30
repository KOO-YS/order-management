package com.manage;

import com.manage.model.Product;
import com.manage.model.Tracking;
import com.manage.resource.ProductResource;
import com.manage.resource.TrackingResource;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/customer/order")
public class CustomerResource {

    private static final Logger LOG = Logger.getLogger(CustomerResource.class);

    @Inject
    TrackingResource trackingResource;
    @Inject
    ProductResource productResource;

    @Channel("order-product")
    Emitter<Tracking> trackingEmitter;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }

    @POST
    @Transactional
    public Response orderProduct(Product product) {
        Product saveProduct = productResource.add(product);
        LOG.info("save Product -> "+ product);
        Tracking tracking = Tracking.builder().product(saveProduct).status("customer order product (주문 완료)").build();
        // DB에 저장
        tracking = trackingResource.add(tracking);

        LOG.info(tracking);
        // refs -> https://quarkus.io/guides/resteasy-reactive#returning-a-response-body
        trackingEmitter.send(tracking);

        return Response.ok().entity(product).build();
    }

    // 모든 상태 공유 받기
    @Incoming("to-customer")
    public void getTrackingStatus(Tracking tracking) {
        // DB 정보 업데이트 하기
        LOG.info("GET DELIVERY MESSAGE \n -> "+tracking);
        trackingResource.update(tracking.getId(), tracking);
    }
}