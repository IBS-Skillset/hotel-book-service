package com.hotel.api.book.util;

public class ApiUtils {

    public static String maskSensitiveData(String log) {
        return log.replaceAll(Constants.CVV, Constants.CVV_MASK)
                .replaceAll(Constants.CARD_NUMBER ,Constants.CARD_NUMBER_MASK);
    }
}
