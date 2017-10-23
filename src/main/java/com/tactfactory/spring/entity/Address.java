package com.tactfactory.spring.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column
    private String text;

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

//    @ManyToOne()
//    private Customer customer;

    @ManyToMany(targetEntity = Customer.class, mappedBy = "addresses")
    private List<Customer> customers;

//    /**
//     * @return the customer
//     */
//    public Customer getCustomer() {
//        return customer;
//    }
//
//    /**
//     * @param customer the customer to set
//     */
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
////        if (customer.getAddress()==null) {
////            customer.setAddress(this);
////        }
//        if (!customer.getAddresses().contains(this)) {
//            customer.getAddresses().add(this);
//        }
//    }

    /**
     * @return the customers
     */
    public List<Customer> getCustomers() {
        return customers;
    }

    /**
     * @param customers the customers to set
     */
    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    protected Address() { }

    public Address(String name) {
        this.text = name;
        this.customers = new ArrayList<Customer>();
    }
}
