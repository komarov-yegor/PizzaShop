package Kom.order;

import Kom.item.Pizza;
import Kom.customer.Customer;

public class Order {

    private int id;
    private String date;
    private String deliveriTime;
    private String deliveriTimeEst;
    private String address;
    private Customer customer;
    private Pizza pizza;
    private int customerId;
    private int pizzaId;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDeliveriTime() {
        return deliveriTime;
    }

    public void setDeliveriTime(String deliveriTime) {
        this.deliveriTime = deliveriTime;
    }

    public String getDeliveriTimeEst() {
        return deliveriTimeEst;
    }

    public void setDeliveriTimeEst(String deliveriTimeEst) {
        this.deliveriTimeEst = deliveriTimeEst;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(int pizzaId) {
        this.pizzaId = pizzaId;
    }
}
