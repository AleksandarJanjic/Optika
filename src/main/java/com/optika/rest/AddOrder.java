package com.optika.rest;

import com.optika.interfaces.AngleInterface;
import com.optika.interfaces.BuyerInterface;
import com.optika.interfaces.DiopterInterface;
import com.optika.interfaces.OrderInterface;
import com.optika.model.Buyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping
    public void addOrder(
            @RequestParam("id") int id,
            @RequestParam("date") Date date,
            @RequestParam(value = "od_sph", required = false) Double od_sph,
            @RequestParam(value = "os_sph", required = false) Double os_sph,
            @RequestParam(value = "od_cyl", required = false) Double od_cyl,
            @RequestParam(value = "os_cyl", required = false) Double os_cyl,
            @RequestParam(value = "od_angle", required = false) Integer od_angle,
            @RequestParam(value = "os_angle", required = false) Integer os_angle,
            @RequestParam(value = "pd", required = false) Double pd,
            @RequestParam("type") String type,
            @RequestParam(value = "frame", required = false) String frame,
            @RequestParam(value = "comment", required = false) String comment
            ){
        Buyer buyer = buyerInterface.findById(id);

    }
}
