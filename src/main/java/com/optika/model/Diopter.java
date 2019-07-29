package com.optika.model;

import javax.persistence.*;

@Entity
@Table(name = "dioptrija")
public class Diopter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "iddioptrija")
    private int iddioptrija;

    @Column(name = "dioptrija")
    private double diopter;

    public int getIddioptrija() {
        return iddioptrija;
    }

    public void setIddioptrija(int iddioptrija) {
        this.iddioptrija = iddioptrija;
    }

    public double getDiopter() {
        return diopter;
    }

    public void setDiopter(double diopter) {
        this.diopter = diopter;
    }
}
