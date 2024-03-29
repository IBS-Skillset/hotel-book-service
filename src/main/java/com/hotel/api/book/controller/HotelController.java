package com.hotel.api.book.controller;

import com.hotel.api.book.model.RateRuleRequest;
import com.hotel.api.book.model.book.request.BookRequest;
import com.hotel.api.book.service.HotelBookService;
import com.hotel.api.book.service.HotelRateRuleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
@AllArgsConstructor
public class HotelController {

    private HotelRateRuleService hotelRateRuleService;

    private HotelBookService hotelBookService;

    @PostMapping(value = "/raterule")
    public String getRateRuleResponse(@RequestBody RateRuleRequest request) throws Exception {
        return hotelRateRuleService.service(request);
    }

    @PostMapping(value = "/book")
    public String getBookResponse(@RequestBody BookRequest request) throws Exception {
        return hotelBookService.service(request);

    }

}
