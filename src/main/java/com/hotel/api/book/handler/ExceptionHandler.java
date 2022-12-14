package com.hotel.api.book.handler;

import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
@Slf4j
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(StatusRuntimeException.class)
    public ResponseEntity<String> handleGRPCUnauthenticatedException(StatusRuntimeException exception){
        log.error(exception.toString());
        if(exception.getStatus().equals(Status.CANCELLED))
            return new ResponseEntity<>(exception.getTrailers().get(Metadata.Key.of("error", Metadata.ASCII_STRING_MARSHALLER)),HttpStatus.SERVICE_UNAVAILABLE);
        return new ResponseEntity<>(exception.getMessage(),HttpStatus.UNAUTHORIZED);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handleGenericException(Throwable exception){
        log.error(exception.toString());
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_GATEWAY);
    }
}
