package com.hotel.api.book.mappers.common;

import com.hotel.api.book.model.SupplierCredential;
import com.hotel.service.common.Context;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RequestContextMapper {

    private final String url;
    private final SupplierCredential supplierCredential;

    public RequestContextMapper(@Value("${supplier.endPoint.url}") String url, SupplierCredential supplierCredential) {
        this.url = url;
        this.supplierCredential = supplierCredential;
    }

    public Context map() {
        return Context.newBuilder()
                .setSupplierUrl(url)
                .setSupplierCredential(supplierCredential.getPassword())
                .setSupplierRequestorId(supplierCredential.getRequestorId())
                .build();
    }
}
