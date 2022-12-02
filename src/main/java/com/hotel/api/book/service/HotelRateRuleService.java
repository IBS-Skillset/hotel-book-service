package com.hotel.api.book.service;

import com.google.protobuf.util.JsonFormat;
import com.hotel.api.book.mappers.common.RequestContextMapper;
import com.hotel.api.book.model.RateRuleRequest;
import com.hotel.service.raterule.HotelRateRuleRequest;
import com.hotel.service.raterule.HotelRateRuleServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelRateRuleService {

    @GrpcClient("hotel-rate-pad")
    HotelRateRuleServiceGrpc.HotelRateRuleServiceBlockingStub hotelRateRuleServiceBlockingStub;

    @Autowired
    RequestContextMapper requestContextMapper;

    public String service(RateRuleRequest request) throws Exception {
        HotelRateRuleRequest rateRuleRequest = HotelRateRuleRequest.newBuilder()
                .setHotelCode(request.getHotelCode())
                .setLanguageCode(request.getLanguageCode())
                .setRatePlanId(request.getRatePlanId())
                .setStartDate(request.getCheckInDate())
                .setEndDate(request.getCheckOutDate())
                .setRoomCount(request.getRoomCount())
                .setRequestContext(requestContextMapper.map()).build();
        return JsonFormat.printer().print(hotelRateRuleServiceBlockingStub.getHotelRateRule(rateRuleRequest));
    }
}
