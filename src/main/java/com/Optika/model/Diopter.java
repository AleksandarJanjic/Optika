package com.Optika.model;

import javax.persistence.*;

@Entity
@Table(name = "dioptrija")
public class Diopter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int iddioptrija;

    private double diopter;
}
