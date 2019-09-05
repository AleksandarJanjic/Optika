package com.optika.rest;

import com.optika.interfaces.BuyerInterface;
import com.optika.interfaces.OrderInterface;
import com.optika.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/getOrder")
public class GetOrder {

    @Autowired
    OrderInterface orderInterface;

    @Autowired
    BuyerInterface buyerInterface;

    @GetMapping("/getOrderById")
    public HashMap<String, Order> getOrderById(
            @RequestParam("id") int id
    ){
        HashMap<String, Order> theResult = new HashMap<>();
        List<Order> result = orderInterface.findByBuyerOrderByDateDesc(buyerInterface.findById(id));
        for (Order o: result
             ) {
            StringBuilder sb = new StringBuilder();
            sb.append(o.getComment());
            sb.append(" ");
            sb.append(o.getDate().toString());
            theResult.put(sb.toString(), o);
        }
        System.out.println("GET Request for orders by userId: " + id);
        return theResult;
    }
}
