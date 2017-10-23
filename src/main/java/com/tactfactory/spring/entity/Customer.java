package com.tactfactory.spring.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column
    private String firstName;

    @Column(name="")
    private String lastName;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="address_id")
//    private Address address;

//    @OneToMany(mappedBy="customer", cascade=CascadeType.ALL)
    @ManyToMany(targetEntity = Address.class , cascade = CascadeType.ALL)
    @JoinTable(name="rel_A2C")
    private List<Address> addresses;

//    /**
//     * @return the address
//     */
//    public Address getAddress() {
//        return address;
//    }
//
//    /**
//     * @param address the address to set
//     */
//    public void setAddress(Address address) {
//        this.address = address;
//        if (address.getCustomer() == null) {
//            address.setCustomer(this);
//        }
//    }

    /**
     * @return the addresses
     */
    public List<Address> getAddresses() {
        return addresses;
    }

    /**
     * @param addresses the addresses to set
     */
    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public void setAddresse(Address address) {
        this.addresses.add(address);
//        if (address.getCustomer() == null) {
//            address.setCustomer(this);
//        }
    }

    protected Customer() {}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName  = lastName;
        this.addresses = new ArrayList<Address>();
    }

    @Override
    public String toString() {
        return String.format("Customer[firstName='%s', lastName='%s']", this.firstName , this.lastName);
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
