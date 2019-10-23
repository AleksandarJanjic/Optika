package com.optika.model;

import javax.persistence.*;

@Entity
@Table(name = "dioptrija")
public class Diopter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Diopter(double diopter) {
        this.diopter = diopter;
    }

    public Diopter() {
        this.diopter = 0.0;
    }
}
