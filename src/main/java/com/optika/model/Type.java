package com.optika.model;

import javax.persistence.*;

@Entity
@Table(name = "tip")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tip")
    private int id_tip;

    @Column(name = "tip")
    private String tip;

    public int getId_tip() {
        return id_tip;
    }

    public void setId_tip(int id_tip) {
        this.id_tip = id_tip;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Type(String typeName) {
        this.tip = typeName;
    }

    public Type() {}
}
