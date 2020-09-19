package com.cumulative.timer.cumulative.timer.initializer;


import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class InitializeTimer {

    public static AtomicInteger arrayPointer = new AtomicInteger(0);

    //@Value( "${timer.storage.size}" )
     public static int storageSize = 1801;

    public static int[] TIME_STORAGE;

    @PostConstruct
    public void initializeStorage() {
        TIME_STORAGE = new int[storageSize];
    }
}
