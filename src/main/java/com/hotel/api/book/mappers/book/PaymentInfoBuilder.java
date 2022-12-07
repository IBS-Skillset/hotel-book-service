package com.hotel.api.book.mappers.book;

import com.hotel.service.book.PaymentInfo;
import org.springframework.stereotype.Component;

import static com.hotel.service.util.ProtoBufUtil.safeSetProtoField;

@Component
public class PaymentInfoBuilder {

    public PaymentInfo map(com.hotel.api.book.model.book.request.PaymentInfo request) {
        PaymentInfo.Builder paymentInfo = PaymentInfo.newBuilder();
        safeSetProtoField(paymentInfo::setPaymentType, request.getPaymentType());
        safeSetProtoField(paymentInfo::setCardType, request.getCardType());
        safeSetProtoField(paymentInfo::setCardNumber, request.getCardNumber());
        safeSetProtoField(paymentInfo::setCvv, request.getCvv());
        safeSetProtoField(paymentInfo::setCardExpireDate, request.getExpiryDate());
        safeSetProtoField(paymentInfo::setCardHolderName, request.getCardHolderName());
        return paymentInfo.build();
    }
}
