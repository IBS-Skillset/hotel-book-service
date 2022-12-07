package com.hotel.api.book.controller;

import com.hotel.api.book.model.RateRuleRequest;
import com.hotel.api.book.service.HotelRateRuleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class HotelRateRuleControllerTest {

    @Mock
    private HotelRateRuleService hotelRateRuleService;

    @InjectMocks
    private HotelRateRuleController hotelRateRuleController;

    @Test
    public void testGetRateRuleResponse() throws Exception {
        RateRuleRequest request = new RateRuleRequest();
        request.setHotelCode("ab");
        request.setRatePlanId("12ab");
        request.setCheckInDate("01-01-2022");
        request.setCheckOutDate("02-01-2022");
        request.setRoomCount(1);
        request.setLanguageCode("ENG");
        hotelRateRuleController.getRateRuleResponse(request);
        verify(hotelRateRuleService,atLeast(1)).service(request);



    }
}