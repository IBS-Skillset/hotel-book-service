package com.hotel.api.book.mappers.book;

import com.hotel.api.book.model.book.request.PaymentInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import static com.hotel.api.book.util.MockResponse.getPaymentInfo;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class PaymentInfoBuilderTest {

    @InjectMocks
    private PaymentInfoBuilder paymentInfoBuilder;

    @Test
    public void map() {
        PaymentInfo paymentInfo = getPaymentInfo();
        com.hotel.service.book.PaymentInfo response = paymentInfoBuilder.map(paymentInfo);
        assertThat(response).isNotNull();
        assertThat(response.getCardHolderName()).isEqualTo("Ash");
        assertThat(response.getCardNumber()).isEqualTo("1234");
        assertThat(response.getPaymentType()).isEqualTo("cash");
        assertThat(response.getCvv()).isEqualTo("123");
        assertThat(response.getCardType()).isEqualTo("debit");
        assertThat(response.getCardExpireDate()).isEqualTo("12/22");
    }
}