package com.optika.rest;

import com.optika.model.Angle;
import com.optika.model.Buyer;
import com.optika.model.Diopter;
import com.optika.model.Type;
import com.optika.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UtilityREST {

    @Autowired
    AngleService angleService;

    @Autowired
    DiopterService diopterService;

    @Autowired
    TypeService typeService;

    @Autowired
    UtilService utilService;

    @Autowired
    BuyerService buyerService;

    @PostMapping("/Util/AddAngle")
    public String addAngle(
            @RequestParam("angle") int angle
    ) {
        Angle angleValue = new Angle(angle);
        String res = angleService.persistAngle(angleValue);
        return res;
    }

    @PostMapping("/Util/AddDiopter")
    public String addDiopter(
            @RequestParam("diopter") double diopterValue
    ) {
        Diopter diopter = new Diopter(diopterValue);
        String res = diopterService.persistDiopter(diopter);
        return res;
    }

    @PostMapping("/Util/AddType")
    public String addType(
            @RequestParam("type") String typeName
    ) {
        Type type = new Type(typeName);
        String res = typeService.persistType(type);
        return res;
    }

    @PostMapping("utilService/countSearch")
    public String countSearch(
            @RequestParam("counter") int counter
    ) {
        Buyer buyer = buyerService.findById(counter);
        buyer.setName(String.valueOf(counter));
        String res = utilService.countSearch(buyer);
        return res;
    }

    @PostMapping("utilService/countAdd")
    public String countAdd(
            @RequestParam("counter") int counter
    ){
        Buyer buyer = buyerService.findById(counter);
        buyer.setName(String.valueOf(counter));
        String res = utilService.countAdd(buyer);
        return res;
    }
}
