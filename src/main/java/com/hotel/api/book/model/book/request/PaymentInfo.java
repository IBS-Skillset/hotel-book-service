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
public class PaymentInfo {
    private String paymentType;
    private String cardType;
    private String cardNumber;
    private String cvv;
    private String expiryDate;
    private String cardHolderName;
}