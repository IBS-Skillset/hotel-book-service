package com.hotel.api.book.model.book.request;

import lombok.Data;

@Data
public class UserInfo {
    private String prefix;
    private String givenName;
    private String surName;
    private String phoneNumber;
    private String email;
    private Address address;
}