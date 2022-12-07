package com.hotel.api.book.mappers.book;

import com.hotel.service.common.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.hotel.service.util.ProtoBufUtil.safeSetProtoField;

@Component
public class UserInfoBuilder {

    @Autowired
    AddressBuilder addressBuilder;

    public UserInfo map(com.hotel.api.book.model.book.request.UserInfo userInfo) {
        UserInfo.Builder userInfoBuilder = UserInfo.newBuilder();
        safeSetProtoField(userInfoBuilder::setNamePrefix, userInfo.getPrefix());
        safeSetProtoField(userInfoBuilder::setFirstName, userInfo.getGivenName());
        safeSetProtoField(userInfoBuilder::setLastName, userInfo.getSurName());
        safeSetProtoField(userInfoBuilder::setPhoneNumber, userInfo.getPhoneNumber());
        safeSetProtoField(userInfoBuilder::setEmail, userInfo.getEmail());
        safeSetProtoField(userInfoBuilder::setAddress, addressBuilder.map(userInfo.getAddress()));
        return userInfoBuilder.build();
    }
}
