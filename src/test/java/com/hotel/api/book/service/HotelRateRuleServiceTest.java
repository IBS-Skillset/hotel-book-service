package com.hotel.api.book.service;

import com.hotel.api.book.mappers.common.RequestContextMapper;
import com.hotel.api.book.model.RateRuleRequest;
import com.hotel.service.common.Context;
import com.hotel.service.raterule.HotelRateRuleRequest;
import com.hotel.service.raterule.HotelRateRuleResponse;
import com.hotel.service.raterule.HotelRateRuleServiceGrpc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HotelRateRuleServiceTest {

    @Mock
    private RequestContextMapper requestContextMapper;

    @Mock
    private HotelRateRuleServiceGrpc.HotelRateRuleServiceBlockingStub hotelRateRuleServiceBlockingStub;

    @InjectMocks
    private HotelRateRuleService hotelRateRuleService;

    @Test
    public void testService() throws Exception {
        RateRuleRequest request = new RateRuleRequest();
        request.setHotelCode("ab");
        request.setRatePlanId("12ab");
        request.setCheckInDate("01/01/2022");
        request.setCheckOutDate("02/01/2022");
        request.setRoomCount(1);
        request.setLanguageCode("ENG");
        Context context = Context.newBuilder().build();
        when(requestContextMapper.map()).thenReturn(context);
        when(hotelRateRuleServiceBlockingStub.getHotelRateRule(any())).thenReturn(HotelRateRuleResponse.newBuilder().build());
        hotelRateRuleService.service(request);
        assertThat(hotelRateRuleService.service(request)).isNotNull();
    }
}