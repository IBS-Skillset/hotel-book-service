package com.hotel.api.book.service;

import com.google.protobuf.util.JsonFormat;
import com.hotel.api.book.mappers.book.BookRequestBuilder;
import com.hotel.api.book.model.book.request.BookRequest;
import com.hotel.api.book.util.Constants;
import com.hotel.service.book.HotelBookRequest;
import com.hotel.service.book.HotelBookServiceGrpc;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.hotel.api.book.util.ApiUtils.maskSensitiveData;

@Service
@Slf4j
public class HotelBookService {
    @GrpcClient("hotel-book-reprice-pad")
    HotelBookServiceGrpc.HotelBookServiceBlockingStub hotelBookServiceBlockingStub;

    @Autowired
    BookRequestBuilder bookRequestBuilder;

    public String service(BookRequest request) throws Exception {
        HotelBookRequest hotelBookRequest = bookRequestBuilder.map(request);
        log.info("Calling grpc service for request " + maskSensitiveData(hotelBookRequest.toString()));
        String response = JsonFormat.printer().print(hotelBookServiceBlockingStub.getHotelBook(hotelBookRequest));
        log.info("Response" + response);
        return response;
    }

}
