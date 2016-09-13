package Kom.order;


import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

@ApplicationScoped
public class OrderRepository {

    private static final Logger LOGGER = Logger.getLogger(OrderRepository.class.getName());

    private Map<Integer, Order> orders;

    @PostConstruct
    public void init() {
        LOGGER.info("Create repository Order!");
        orders = new ConcurrentHashMap<>();
    }

    public boolean contains(int id) {
        return orders.containsKey(id);
    }

    public List<Order> findAllOrders() {
        LOGGER.info("Find All Orders!");
        return new ArrayList<>(orders.values());
    }

    public Optional<Order> findOrderID(int id) {
        LOGGER.info(String.format("Finde order '%s'.", id));
        return Optional.ofNullable(orders.get(id));
    }

    public void deleteOrder(int id) {
        LOGGER.info(String.format("Delete customer'%s'.", id));
        orders.remove(id);
    }

    public void updateOrder(Order order) {
        Objects.requireNonNull(order);
        LOGGER.info(String.format("Update order'%s'.", order.getId()));
        orders.put(order.getId(), order);
    }
}
