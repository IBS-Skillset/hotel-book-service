package com.hotel.api.book.model.book.request;

import lombok.Data;

@Data
public class BookRequest {

    private String languageCode;
    private String hotelCode;
    private String countryCode;
    private String ratePlanId;
    private int numberOfRooms;
    private int guestCount;
    private String startDate;
    private String endDate;
    private PaymentInfo paymentInfo;
    private UserInfo userInfo;
}