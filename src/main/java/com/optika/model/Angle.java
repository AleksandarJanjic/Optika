package com.optika.model;

import javax.persistence.*;

@Entity
@Table(name = "ugao")
public class Angle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idugao;

    @Column(name = "ugao")
    private int angle;

    public int getIdugao() {
        return idugao;
    }

    public void setIdugao(int idugao) {
        this.idugao = idugao;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }
}
