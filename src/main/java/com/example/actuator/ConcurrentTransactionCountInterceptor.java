package com.example.actuator;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ConcurrentTransactionCountInterceptor extends HandlerInterceptorAdapter {
    private final Counter counter;

    public ConcurrentTransactionCountInterceptor(MeterRegistry meterRegistry) {
        this.counter = meterRegistry.counter("transaction.current.count");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        counter.increment();
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        counter.increment(-1d);
    }
}
