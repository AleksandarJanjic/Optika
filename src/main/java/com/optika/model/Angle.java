package com.optika.model;

import javax.persistence.*;

@Entity
@Table(name = "ugao")
public class Angle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idugao;

    @Column(name = "ugao")
    private Integer angle;

    public int getIdugao() {
        return idugao;
    }

    public void setIdugao(int idugao) {
        this.idugao = idugao;
    }

    public Integer getAngle() {
        return angle;
    }

    public void setAngle(Integer angle) {
        this.angle = angle;
    }

    public Angle(int angle) {
        this.angle = angle;
    }

    public Angle() { }
}
