package com.hotel.api.book.model.book.request;

import lombok.Setter;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Builder;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder(toBuilder = true)
public class HotelBookRequest {

    private String languageCode;
    private String hotelCode;
    private String countryCode;
    private String currencyCode;
    private String ratePlanId;
    private int numberOfRooms;
    private int guestCount;
    private String startDate;
    private String endDate;
    private PaymentInfo paymentInfo;
    private UserInfo userInfo;
}