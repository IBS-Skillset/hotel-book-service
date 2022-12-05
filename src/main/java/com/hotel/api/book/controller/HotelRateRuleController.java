package com.hotel.api.book.controller;

import com.hotel.api.book.model.RateRuleRequest;
import com.hotel.api.book.service.HotelRateRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class HotelRateRuleController {

    @Autowired
    private HotelRateRuleService hotelRateRuleService;

    @PostMapping(value = "/raterule")
    public String getRateRuleResponse(@RequestBody RateRuleRequest request) throws Exception {
        return hotelRateRuleService.service(request);
    }

}
