package com.optika.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pregled")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_pregled")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_kupac")
    private Buyer buyer;

    @Column(name = "datum")
    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dioptrija_od_sph")
    private Diopter od_sph;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dioptrija_os_sph")
    private Diopter os_sph;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dioptrija_od_cyl")
    private Diopter od_cyl;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dioptrija_os_cyl")
    private Diopter os_cyl;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ugao_od")
    private Angle od_angle;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ugao_os")
    private Angle os_angle;

    @Column(name = "pd")
    private double pd;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tip")
    private Type type;

    @Column(name = "okvir")
    private String frame;

    @Column(name = "komentar")
    private String comment;

    @Column(name = "hasaddition")
    private Boolean hasAddition;

    @Column(name = "addition")
    private String addition;

    public Order(){}

    public Order(Buyer buyer,
                 Date date,
                 Diopter od_sph,
                 Diopter os_sph,
                 Diopter od_cyl,
                 Diopter os_cyl,
                 Angle od_angle,
                 Angle os_angle,
                 double pd,
                 Type type,
                 String frame,
                 String comment,
                 Boolean hasAddition,
                 String addition
    ){
        this.buyer = buyer;
        this.date = date;
        this.od_sph = od_sph;
        this.os_sph = os_sph;
        this.od_cyl = od_cyl;
        this.os_cyl = os_cyl;
        this.od_angle = od_angle;
        this.os_angle = os_angle;
        this.pd = pd;
        this.type = type;
        this.frame = frame;
        this.comment = comment;
        this.hasAddition = hasAddition;
        this.addition = addition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Diopter getOd_sph() {
        return od_sph;
    }

    public void setOd_sph(Diopter od_sph) {
        this.od_sph = od_sph;
    }

    public Diopter getOs_sph() {
        return os_sph;
    }

    public void setOs_sph(Diopter os_sph) {
        this.os_sph = os_sph;
    }

    public Diopter getOd_cyl() {
        return od_cyl;
    }

    public void setOd_cyl(Diopter od_cyl) {
        this.od_cyl = od_cyl;
    }

    public Diopter getOs_cyl() {
        return os_cyl;
    }

    public void setOs_cyl(Diopter os_cyl) {
        this.os_cyl = os_cyl;
    }

    public Angle getOd_angle() {
        return od_angle;
    }

    public void setOd_angle(Angle od_angle) {
        this.od_angle = od_angle;
    }

    public Angle getOs_angle() {
        return os_angle;
    }

    public void setOs_angle(Angle os_angle) {
        this.os_angle = os_angle;
    }

    public double getPd() {
        return pd;
    }

    public void setPd(double pd) {
        this.pd = pd;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Boolean isHasAddition() {
        return hasAddition;
    }

    public void setHasAddition(Boolean hasAddition) {
        this.hasAddition = hasAddition;
    }

    public String getAddition() {
        return addition;
    }

    public void setAddition(String addition) {
        this.addition = addition;
    }
}
