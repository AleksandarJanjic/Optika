package com.optika.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.FilterJoinTable;
import org.hibernate.annotations.ParamDef;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "kupac")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_kupac")
    private int id;

    @Column(name = "ime_kupac")
    private String name;

    @Column(name = "prezime_kupac", nullable = false)
    private String lastname;

    @OneToMany(mappedBy = "buyer")
    private List<Contact> contacts = new ArrayList<>();

    public Buyer(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public Buyer(String name) {
        this.name = name;
    }

    public Buyer() {}

    public void addContact(Contact contact) {
        contacts.add(contact);
        contact.setBuyer(this);
    }

    public void removeContact(Contact contact) {
        contacts.remove(contact);
        contact.setBuyer(null);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
