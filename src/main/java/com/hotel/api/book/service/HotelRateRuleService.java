package com.hotel.api.book.service;

import com.google.protobuf.util.JsonFormat;
import com.hotel.api.book.mappers.common.RequestContextMapper;
import com.hotel.api.book.model.RateRuleRequest;
import com.hotel.service.raterule.HotelRateRuleRequest;
import com.hotel.service.raterule.HotelRateRuleServiceGrpc;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HotelRateRuleService {

    @GrpcClient("hotel-book-reprice-pad")
    HotelRateRuleServiceGrpc.HotelRateRuleServiceBlockingStub hotelRateRuleServiceBlockingStub;

    @Autowired
    private RequestContextMapper requestContextMapper;

    public String service(RateRuleRequest request) throws Exception {
        log.info(request.toString());
        HotelRateRuleRequest rateRuleRequest = HotelRateRuleRequest.newBuilder()
                .setHotelCode(request.getHotelCode())
                .setLanguageCode(request.getLanguageCode())
                .setRatePlanId(request.getRatePlanId())
                .setStartDate(request.getCheckInDate())
                .setEndDate(request.getCheckOutDate())
                .setRoomCount(request.getRoomCount())
                .setRequestContext(requestContextMapper.map()).build();
        log.info("Calling grpc service for request " + rateRuleRequest);
        String response = JsonFormat.printer().print(hotelRateRuleServiceBlockingStub.getHotelRateRule(rateRuleRequest));
        log.info("Response " + response);
        return response;
    }
}
