package com.hotel.api.book.mappers.book;

import com.hotel.service.common.Address;
import org.springframework.stereotype.Component;

import static com.hotel.service.util.ProtoBufUtil.safeSetProtoField;

@Component
public class AddressBuilder {
    public Address map(com.hotel.api.book.model.book.request.Address request) {
        Address.Builder addressBuilder = Address.newBuilder();
        safeSetProtoField(addressBuilder::setStreetAddress, request.getAddressLine());
        safeSetProtoField(addressBuilder::setCityName, request.getCityName());
        safeSetProtoField(addressBuilder::setCountryName, request.getCountryName());
        safeSetProtoField(addressBuilder::setCountryCode, request.getCountryCode());
        safeSetProtoField(addressBuilder::setZipCode, request.getPostalCode());
        return addressBuilder.build();
    }
}
