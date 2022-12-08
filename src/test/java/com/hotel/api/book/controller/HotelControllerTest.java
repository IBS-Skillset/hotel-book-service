package com.hotel.api.book.controller;

import com.hotel.api.book.model.RateRuleRequest;
import com.hotel.api.book.model.book.request.BookRequest;
import com.hotel.api.book.model.book.request.PaymentInfo;
import com.hotel.api.book.model.book.request.UserInfo;
import com.hotel.api.book.service.HotelBookService;
import com.hotel.api.book.service.HotelRateRuleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class HotelControllerTest {

    @Mock
    private HotelRateRuleService hotelRateRuleService;

    @Mock
    private HotelBookService hotelBookService;

    @InjectMocks
    private HotelController hotelController;

    @Test
    public void testGetRateRuleResponse() throws Exception {
        RateRuleRequest request = new RateRuleRequest();
        request.setHotelCode("ab");
        request.setRatePlanId("12ab");
        request.setCheckInDate("01-01-2022");
        request.setCheckOutDate("02-01-2022");
        request.setRoomCount(1);
        request.setLanguageCode("ENG");
        hotelController.getRateRuleResponse(request);
        verify(hotelRateRuleService, atLeast(1)).service(request);
    }

    @Test
    public void testGetBookResponse() throws Exception{
        BookRequest request = new BookRequest();
        request.setLanguageCode("ENG");
        request.setHotelCode("ab");
        request.setCountryCode("in");
        request.setRatePlanId("12ab");
        request.setNumberOfRooms(1);
        request.setGuestCount(1);
        request.setStartDate("01-01-2022");
        request.setEndDate("02-01-2022");
        hotelController.getBookResponse(request);
        verify(hotelBookService, atLeast(1)).service(request);

    }
}