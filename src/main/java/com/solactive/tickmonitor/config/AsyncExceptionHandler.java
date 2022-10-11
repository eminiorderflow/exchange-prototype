package com.solactive.tickmonitor.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.logging.Logger;

@Component
public class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

    Logger logger = Logger.getLogger(AsyncExceptionHandler.class.getName());

    @Override
    public void handleUncaughtException(Throwable ex, Method method, Object... objects) {
        logger.info("Method name: " + method.getName() +
                          "---" + Arrays.toString(objects) +
                          " Error: + " + ex.getMessage());
    }
}
