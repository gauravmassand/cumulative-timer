package com.cumulative.timer.cumulative.timer.scheduler;

import com.cumulative.timer.cumulative.timer.initializer.InitializeTimer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ScheduleRandom {

    Logger logger = LoggerFactory.getLogger(ScheduleRandom.class);

    static Integer minRange = 1;

    static Integer maxRange = 20;

    @Scheduled(fixedRate = 1000)
    public void generateRandomNumbers() {
        int currentPosition = InitializeTimer.arrayPointer.addAndGet(1);
        int sumGenerated = generateRandomSum();
        int cumulativeSum = InitializeTimer.TIME_STORAGE[(currentPosition-1) % InitializeTimer.storageSize] + sumGenerated;
        InitializeTimer.TIME_STORAGE[currentPosition % InitializeTimer.storageSize] = cumulativeSum;
        logger.info("current Position : {} Sum generated : {}  Cumulative Sum in Array :  {}", currentPosition, sumGenerated, cumulativeSum);
    }

    public int generateRandomSum() {
        int sumNumbers = 0;
        Random random = new Random();
        for(int i = 0; i < 5; i++) {
            sumNumbers +=  random.nextInt(maxRange - minRange) + minRange;
        }
        return sumNumbers;
    }

}
