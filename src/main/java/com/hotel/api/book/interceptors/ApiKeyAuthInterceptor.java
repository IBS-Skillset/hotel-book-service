package com.hotel.api.book.interceptors;

import com.hotel.api.book.util.Constants;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ForwardingClientCall;
import io.grpc.MethodDescriptor;
import io.grpc.Metadata;
import io.grpc.Channel;
import io.grpc.CallOptions;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.interceptor.GrpcGlobalClientInterceptor;
import org.slf4j.MDC;

@GrpcGlobalClientInterceptor
@Slf4j
public class ApiKeyAuthInterceptor implements ClientInterceptor {
    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions, Channel channel) {
        log.info("client interceptor {}", methodDescriptor.getFullMethodName());
        return new
                ForwardingClientCall.SimpleForwardingClientCall<>(channel.newCall(methodDescriptor, callOptions)) {
                    @Override
                    public void start(Listener<RespT> responseListener, Metadata headers) {
                    headers.put(Metadata.Key.of("accesstoken", Metadata.ASCII_STRING_MARSHALLER), MDC.get(Constants.TOKEN));
                    super.start(responseListener, headers);
                    }
                };
    }
}
