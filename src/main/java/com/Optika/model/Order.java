package com.Optika.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pregled")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_pregled;

    @ManyToOne
    @JoinColumn
    private Buyer buyer;

    @Temporal(TemporalType.DATE)
    private Date datum;
}
