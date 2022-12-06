package com.hotel.api.book.model.book.request;


import lombok.Data;

@Data
public class Address {
        private String addressLine;
        private String cityName;
        private String postalCode;
        private String countryCode;
        private String countryName;
}
