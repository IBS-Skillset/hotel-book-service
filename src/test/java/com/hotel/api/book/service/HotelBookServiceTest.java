package com.hotel.api.book.service;

import com.hotel.api.book.mappers.book.BookRequestBuilder;
import com.hotel.api.book.model.book.request.BookRequest;
import com.hotel.service.book.HotelBookRequest;
import com.hotel.service.book.HotelBookResponse;
import com.hotel.service.book.HotelBookServiceGrpc;
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
public class HotelBookServiceTest {

    @Mock
    private HotelBookServiceGrpc.HotelBookServiceBlockingStub hotelBookServiceBlockingStub;

    @Mock
    private BookRequestBuilder bookRequestBuilder;

    @InjectMocks
    private HotelBookService hotelBookService;

    @Test
    public void service() throws Exception {
        BookRequest request = getBookRequest();
        HotelBookRequest hotelBookRequest = HotelBookRequest.newBuilder().build();
        when(bookRequestBuilder.map(request)).thenReturn(hotelBookRequest);
        HotelBookResponse hotelBookResponse= HotelBookResponse.newBuilder().build();
        when(hotelBookServiceBlockingStub.getHotelBook(hotelBookRequest)).thenReturn(hotelBookResponse);
        String response = hotelBookService.service(request);
        assertThat(response).isNotNull();
        verify(bookRequestBuilder, atLeast(1)).map(request);
        verify(hotelBookServiceBlockingStub,atLeast(1)).getHotelBook(hotelBookRequest);
    }
}