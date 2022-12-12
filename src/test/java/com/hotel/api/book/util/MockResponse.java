package com.hotel.api.book.util;

import com.hotel.api.book.model.book.request.BookRequest;
import com.hotel.api.book.model.book.request.PaymentInfo;
import com.hotel.api.book.model.book.request.UserInfo;

public final class MockResponse {

    public static BookRequest getBookRequest(){
        BookRequest request = new BookRequest();
        request.setLanguageCode("ENG");
        request.setHotelCode("ab");
        request.setRatePlanId("12ab");
        request.setNumberOfRooms(1);
        request.setGuestCount(1);
        request.setStartDate("01-01-2022");
        request.setEndDate("02-01-2022");
        request.setPaymentInfo(getPaymentInfo());
        request.setUserInfo(getUserInfo());
        return request;
    }

    public static PaymentInfo getPaymentInfo(){
        PaymentInfo paymentInfo = new PaymentInfo();
        paymentInfo.setCardHolderName("Ash");
        paymentInfo.setCardNumber("1234");
        paymentInfo.setPaymentType("cash");
        paymentInfo.setCvv("123");
        paymentInfo.setCardType("debit");
        paymentInfo.setExpiryDate("12/22");
        return paymentInfo;
    }
    public static UserInfo getUserInfo(){
        UserInfo userInfo = new UserInfo();
        userInfo.setPrefix("Ms");
        userInfo.setGivenName("test");
        userInfo.setSurName("123");
        userInfo.setPhoneNumber("9111111111");
        userInfo.setEmail("ash@gmail.com");
        return userInfo;
    }
}

