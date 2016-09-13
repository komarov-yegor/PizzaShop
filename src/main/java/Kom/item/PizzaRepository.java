package Kom.item;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

@ApplicationScoped
public class PizzaRepository {

    private static final Logger LOGGER = Logger.getLogger(PizzaRepository.class.getName());

    private Map<Integer, Pizza> pizzas;

    @PostConstruct
    public void init() {
        LOGGER.info("Create repository Pizza!");
        pizzas = new ConcurrentHashMap<>();
    }

    public boolean contains(int id) {
        return pizzas.containsKey(id);
    }

    public List<Pizza> findAllPizza() {
        LOGGER.info("Find all pizza.");

        return new ArrayList<>(pizzas.values());
    }

    public Optional<Pizza> findTitle(String title) {
        LOGGER.info(String.format("Find '%s'.", title));

        return Optional.ofNullable(pizzas.get(title));
    }

    public Optional<Pizza> findId(int id) {
        LOGGER.info(String.format("Find '%s'.", id));

        return Optional.ofNullable(pizzas.get(id));
    }

    public void delete(int id) {
        LOGGER.info(String.format("Delete '%s'.", id));

        pizzas.remove(id);
    }

    public void update(Pizza piz) {
        Objects.requireNonNull(piz);
        LOGGER.info(String.format("Update '%s'.", piz.getId()));

        pizzas.put(piz.getId(), piz);
    }

}
