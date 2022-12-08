package com.hotel.api.book.service;

import com.hotel.api.book.mappers.book.BookRequestBuilder;
import com.hotel.api.book.model.book.request.BookRequest;
import com.hotel.api.book.model.book.request.PaymentInfo;
import com.hotel.service.book.HotelBookRequest;
import com.hotel.service.book.HotelBookResponse;
import com.hotel.service.book.HotelBookServiceGrpc;
import com.hotel.service.description.HotelDescriptionRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

//@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
class HotelBookServiceTest {

    @Mock
    private HotelBookServiceGrpc.HotelBookServiceBlockingStub hotelBookServiceBlockingStub;

    @Mock
    private BookRequestBuilder bookRequestBuilder;

    @InjectMocks
    private HotelBookService hotelBookService;

    @Test
    public void service() throws Exception {
        BookRequest request = new BookRequest();
        request.setLanguageCode("ENG");
        request.setHotelCode("ab");
        request.setCountryCode("in");
        request.setRatePlanId("12ab");
        request.setNumberOfRooms(1);
        request.setGuestCount(1);
        request.setStartDate("01-01-2022");
        request.setEndDate("02-01-2022");
        PaymentInfo paymentInfo = new PaymentInfo();
        paymentInfo.setCardHolderName("Ash");
        paymentInfo.setCardNumber("1234");
        paymentInfo.setPaymentType("cash");
        paymentInfo.setCvv("123");
        paymentInfo.setCardType("debit");
        paymentInfo.setExpiryDate("12/22");
        request.setPaymentInfo(paymentInfo);
        HotelBookRequest hotelBookRequest = HotelBookRequest.newBuilder().build();
        when(bookRequestBuilder.map(request)).thenReturn(hotelBookRequest);
        HotelBookResponse hotelBookResponse= HotelBookResponse.newBuilder().build();
        when(hotelBookServiceBlockingStub.getHotelBook(hotelBookRequest)).thenReturn(hotelBookResponse);
        String response = hotelBookService.service(request);
        assertThat(response).isNotNull();
    }
}