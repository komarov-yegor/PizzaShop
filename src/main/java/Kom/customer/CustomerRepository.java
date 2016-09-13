package Kom.customer;


import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

@ApplicationScoped
public class CustomerRepository {

    private static final Logger LOGGER = Logger.getLogger(CustomerRepository.class.getName());

    private Map<Integer, Customer> customers;

    @PostConstruct
    public void init() {
        LOGGER.info("Create repository Customer!");
        customers = new ConcurrentHashMap<>();
    }

    public boolean contains(int id) {
        return customers.containsKey(id);
    }

    public List<Customer> findAllCustomers() {
        LOGGER.info("Find All Customers!");
        return new ArrayList<>(customers.values());
    }

    public Optional<Customer> findPhone(String phone) {
        LOGGER.info(String.format("Find customer '%s'.", phone));
        return Optional.ofNullable(customers.get(phone));
    }

    public Optional<Customer> findName(String name) {
        LOGGER.info(String.format("Find customer '%s'.", name));
        return Optional.ofNullable(customers.get(name));
    }

    public Optional<Customer> findCustomerID(int id) {
        LOGGER.info(String.format("Finde customer '%s'.", id));
        return Optional.ofNullable(customers.get(id));
    }

    public void deleteCustomer(int id) {
        LOGGER.info(String.format("Delete customer'%s'.", id));
        customers.remove(id);
    }

    public void updateCustomer(Customer customer) {
        Objects.requireNonNull(customer);
        LOGGER.info(String.format("Update customer'%s'.", customer.getId()));
        customers.put(customer.getId(), customer);
    }
}
