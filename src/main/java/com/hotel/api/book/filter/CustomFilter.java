package com.hotel.api.book.filter;

import com.hotel.api.book.util.Constants;
import org.slf4j.MDC;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import org.springframework.http.HttpHeaders;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CustomFilter implements Filter {

    public CustomFilter() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        MDC.put(Constants.TOKEN,((HttpServletRequest) req).getHeader(HttpHeaders.AUTHORIZATION).substring("Bearer ".length()));
        chain.doFilter(req, res);
        MDC.remove(Constants.TOKEN);
    }

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void destroy() {
    }
}