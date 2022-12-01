package com.hotel.api.book.model.book.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder(toBuilder = true)
public class UserInfo {
    private String prefix;
    private String givenName;
    private String surName;
    private String phoneNumber;
    private String email;
    private Address address;
}