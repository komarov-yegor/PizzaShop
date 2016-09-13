package Kom.item;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.List;
import java.util.Objects;

@Path("items")
public class PizzaResource {

    @Inject
    private PizzaRepository repository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pizza> findAllPizza() {
	return repository.findAllPizza();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Pizza pizza) {

	if (Objects.isNull(pizza.getTitle()) || Objects.isNull(pizza.getDescription()) || Objects.isNull(pizza.getId())) {

	    throw new BadRequestException("Enter title, id and description.");

	}

	if (repository.contains(pizza.getId())) {

	    throw new ForbiddenException("Pizza already exists.");
	}

	repository.update(pizza);

	URI location = UriBuilder.fromResource(PizzaResource.class).path("{id}").build(pizza.getId());

	return Response.created(location).build();

    }
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Pizza findId(@PathParam("id") int id) {
        return repository.findId(id).orElseThrow(() -> new NotFoundException("Pizza not found."));
    }

    @GET
    @Path("{title}")
    @Produces(MediaType.APPLICATION_JSON)
    public Pizza findTitle(@PathParam("title") String title) {
        return repository.findTitle(title).orElseThrow(() -> new NotFoundException("Pizza not found."));
    }


    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") int id) {
	repository.delete(id);
    }
}
