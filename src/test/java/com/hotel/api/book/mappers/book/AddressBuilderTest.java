package com.hotel.api.book.mappers.book;

import com.hotel.api.book.model.book.request.Address;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
//import com.hotel.service.common.Address;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AddressBuilderTest {

    @InjectMocks
    private AddressBuilder addressBuilder;

    @Test
    void map() {
        Address address = getAddress();
        com.hotel.service.common.Address addressResponse = addressBuilder.map(address);
        assertThat(addressResponse).isNotNull();
        assertThat(addressResponse.getCityName()).isEqualTo("Paris");
        assertThat(addressResponse.getStreetAddress()).isEqualTo("Hotel Paris, Street1, France");
        assertThat(addressResponse.getCountryName()).isEqualTo("France");
        assertThat(addressResponse.getCountryCode()).isEqualTo("FR");
        assertThat(addressResponse.getZipCode()).isEqualTo("123456");
    }
    private Address getAddress(){
        Address address = new Address();
        address.setAddressLine("Hotel Paris, Street1, France");
        address.setCityName("Paris");
        address.setCountryName("France");
        address.setCountryCode("FR");
        address.setPostalCode("123456");
        return address;
    }
}