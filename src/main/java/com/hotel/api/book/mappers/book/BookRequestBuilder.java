package com.hotel.api.book.mappers.book;

import com.hotel.api.book.mappers.common.RequestContextMapper;
import com.hotel.api.book.model.book.request.BookRequest;
import com.hotel.service.book.HotelBookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.hotel.service.util.ProtoBufUtil.safeSetProtoField;

@Component
public class BookRequestBuilder {
    @Autowired
    RequestContextMapper requestContextMapper;
    @Autowired
    UserInfoBuilder userInfoBuilder;
    @Autowired
    PaymentInfoBuilder paymentInfoBuilder;


    public HotelBookRequest map(BookRequest request) {
        HotelBookRequest.Builder hotelBookRequest = HotelBookRequest.newBuilder();
        safeSetProtoField(hotelBookRequest::setRequestContext, requestContextMapper.map());
        safeSetProtoField(hotelBookRequest::setLanguageCode, request.getLanguageCode());
        safeSetProtoField(hotelBookRequest::setRatePlanId, request.getRatePlanId());
        safeSetProtoField(hotelBookRequest::setStartDate, request.getStartDate());
        safeSetProtoField(hotelBookRequest::setEndDate, request.getEndDate());
        safeSetProtoField(hotelBookRequest::setHotelCode, request.getHotelCode());
        safeSetProtoField(hotelBookRequest::setRoomCount, request.getNumberOfRooms());
        safeSetProtoField(hotelBookRequest::setGuestCount, request.getGuestCount());
        safeSetProtoField(hotelBookRequest::setUserInfo, userInfoBuilder.map(request.getUserInfo()));
        safeSetProtoField(hotelBookRequest::setPaymentInfo, paymentInfoBuilder.map(request.getPaymentInfo()));
        return hotelBookRequest.build();
    }
}
