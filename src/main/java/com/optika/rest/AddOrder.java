package com.optika.rest;

import com.optika.interfaces.*;
import com.optika.model.*;
import com.optika.model.Order;
import com.optika.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/AddOrder")
public class AddOrder {

    @Autowired
    OrderInterface orderInterface;

    @Autowired
    DiopterInterface diopterInterface;

    @Autowired
    AngleInterface angleInterface;

    @Autowired
    BuyerInterface buyerInterface;

    @Autowired
    TypeInterface typeInterface;

    @PostMapping
    public String addOrder(
            @RequestParam("id") int id,
            @RequestParam("date") String date, //cannot convert date
            @RequestParam(value = "od_sph", required = false) Double od_sph,
            @RequestParam(value = "os_sph", required = false) Double os_sph,
            @RequestParam(value = "od_cyl", required = false) Double od_cyl,
            @RequestParam(value = "os_cyl", required = false) Double os_cyl,
            @RequestParam(value = "od_angle", required = false) Integer od_angle,
            @RequestParam(value = "os_angle", required = false) Integer os_angle,
            @RequestParam(value = "pd", required = false) Double pd,
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "frame", required = false) String frame,
            @RequestParam(value = "comment", required = false) String comment,
            @RequestParam(value = "hasAddition") Boolean hasAddition,
            @RequestParam(value = "addition") Double addition
            ) throws ParseException {
        System.out.println("POST request: addOrder");
        Buyer buyer = buyerInterface.findById(id);
        Diopter od_sph_id = diopterInterface.findByDiopter(od_sph);
        Diopter os_sph_id = diopterInterface.findByDiopter(os_sph);
        Diopter od_cyl_id = diopterInterface.findByDiopter(od_cyl);
        Diopter os_cyl_id = diopterInterface.findByDiopter(os_cyl);
        Angle od_angle_id = angleInterface.findByAngle(od_angle);
        Angle os_angle_id = angleInterface.findByAngle(os_angle);
        Type type_id = typeInterface.findByTip(type);
        Diopter addition_id = diopterInterface.findByDiopter(addition);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date properDate = simpleDateFormat.parse(date);
        Order order = new Order(
                buyer,
                properDate,
                od_sph_id,
                os_sph_id,
                od_cyl_id,
                os_cyl_id,
                od_angle_id,
                os_angle_id,
                pd,
                type_id,
                frame,
                comment,
                hasAddition,
                addition_id
        );
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.saveOrUpdate(order);
        session.getTransaction().commit();
        session.close();
        System.out.println("Order added");
        return String.valueOf(buyer.getId());
    }
}
