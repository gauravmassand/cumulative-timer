package com.cumulative.timer.cumulative.timer.initializer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class InitializeTimer {

    Logger logger = LoggerFactory.getLogger(InitializeTimer.class);

    public static AtomicInteger arrayPointer = new AtomicInteger(0);

     public static int storageSize = 1801;

    public static int[] TIME_STORAGE;

    @PostConstruct
    public void initializeStorage() {
        logger.info("Initializing storage for Timer");
        TIME_STORAGE = new int[storageSize];
    }
}
