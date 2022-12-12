package com.hotel.api.book.mappers.book;

import com.hotel.api.book.model.book.request.UserInfo;
import com.hotel.service.common.Address;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static com.hotel.api.book.util.MockResponse.getUserInfo;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserInfoBuilderTest {

    @Mock
    private AddressBuilder addressBuilder;
    @InjectMocks
    private UserInfoBuilder userInfoBuilder;

    @Test
    public void map() {
        UserInfo userInfo = getUserInfo();
        Address.Builder address = Address.newBuilder();
        when(addressBuilder.map(userInfo.getAddress())).thenReturn(address.build());
        com.hotel.service.common.UserInfo response = userInfoBuilder.map(userInfo);
        assertThat(response).isNotNull();
        assertThat(response.getFirstName()).isEqualTo("test");
        assertThat(response.getLastName()).isEqualTo("123");
        assertThat(response.getEmail()).isEqualTo("ash@gmail.com");
        assertThat(response.getNamePrefix()).isEqualTo("Ms");
        assertThat(response.getPhoneNumber()).isEqualTo("9111111111");
        verify(addressBuilder, atLeast(1)).map(userInfo.getAddress());
    }

}