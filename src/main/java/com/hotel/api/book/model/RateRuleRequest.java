package com.hotel.api.book.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RateRuleRequest {

    private String languageCode;
    private String hotelCode;
    private String checkInDate;
    private String checkOutDate;
    private String ratePlanId;
    private int roomCount;
}
