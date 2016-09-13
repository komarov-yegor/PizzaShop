package Kom.customer;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.List;
import java.util.Objects;

@Path("customers")
public class CustomerResource {

    @Inject
    private CustomerRepository repository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Customer customer) {

        if (Objects.isNull(customer.getPhone()) || Objects.isNull(customer.getName()) || Objects.isNull(customer.getId())) {
            throw new BadRequestException("Enter Name, id and Phone!");
        }

        if (repository.contains(customer.getId())) {
            throw new ForbiddenException("Customer already exists.");
        }

        repository.updateCustomer(customer);

        URI location = UriBuilder.fromResource(CustomerResource.class).path("{id}").build(customer.getId());

        return Response.created(location).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> findAllCustomers(){
        return repository.findAllCustomers();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer findCustomerID(@PathParam("id") int id) {
        return repository.findCustomerID(id).orElseThrow(() -> new NotFoundException("Customer not found."));
    }

}
