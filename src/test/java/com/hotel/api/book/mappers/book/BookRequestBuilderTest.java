package com.hotel.api.book.mappers.book;

import com.hotel.api.book.mappers.common.RequestContextMapper;
import com.hotel.api.book.model.book.request.BookRequest;
import com.hotel.service.book.HotelBookRequest;
import com.hotel.service.common.Context;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static com.hotel.api.book.util.MockResponse.getBookRequest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookRequestBuilderTest {

    @Mock
    private RequestContextMapper requestContextMapper;
    @Mock
    private UserInfoBuilder userInfoBuilder;
    @Mock
    private PaymentInfoBuilder paymentInfoBuilder;
    @InjectMocks
    private BookRequestBuilder bookRequestBuilder;

    @Test
   public void map() {
        BookRequest request = getBookRequest();
        Context context = Context.newBuilder().build();
        when(requestContextMapper.map()).thenReturn(context);
        com.hotel.service.common.UserInfo.Builder userInfo = com.hotel.service.common.UserInfo.newBuilder();
        when(userInfoBuilder.map(request.getUserInfo())).thenReturn(userInfo.build());
        com.hotel.service.book.PaymentInfo.Builder paymentInfo = com.hotel.service.book.PaymentInfo.newBuilder();
        when(paymentInfoBuilder.map(request.getPaymentInfo())).thenReturn(paymentInfo.build());
        HotelBookRequest response = bookRequestBuilder.map(request);
        assertThat(response).isNotNull();
        assertThat(response.getLanguageCode()).isEqualTo("ENG");
        assertThat(response.getHotelCode()).isEqualTo("ab");
        assertThat(response.getRatePlanId()).isEqualTo("12ab");
        assertThat(response.getRoomCount()).isEqualTo(1);
        assertThat(response.getStartDate()).isEqualTo("01-01-2022");
        assertThat(response.getEndDate()).isEqualTo("02-01-2022");
        assertThat(response.getHotelCode()).isEqualTo("ab");
        assertThat(response.getGuestCount()).isEqualTo(1);
        verify(requestContextMapper,atLeast(1)).map();
        verify(userInfoBuilder,atLeast(1)).map(request.getUserInfo());
        verify(paymentInfoBuilder,atLeast(1)).map(request.getPaymentInfo());
    }

}