package Kom.order;

import Kom.customer.CustomerResource;
import Kom.item.PizzaResource;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.List;
import java.util.Objects;

@Path("orders")
public class OrderResource {

    @Inject
    private OrderRepository repository;

    @Inject
    private CustomerResource customerResource;

    @Inject
    private PizzaResource pizzaResource;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Order order) {

        if (Objects.isNull(Objects.isNull(order.getId()) || Objects.isNull(order.getCustomerId())) || Objects.isNull(order.getPizzaId())) {
            throw new BadRequestException("Enter ID, Customer Id, Pizza Id!");
        }

        if (repository.contains(order.getId())) {
            throw new ForbiddenException("Order already exists.");
        }

        order.setCustomer(customerResource.findCustomerID(order.getCustomerId()));
        order.setPizza(pizzaResource.findId(order.getPizzaId()));

        repository.updateOrder(order);

        URI location = UriBuilder.fromResource(OrderResource.class).path("{id}").build(order.getId());

        return Response.created(location).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Order> findAllOrders() {
        return repository.findAllOrders();
    }

}
