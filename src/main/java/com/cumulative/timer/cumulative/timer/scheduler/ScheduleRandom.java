package com.cumulative.timer.cumulative.timer.scheduler;

import com.cumulative.timer.cumulative.timer.initializer.InitializeTimer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ScheduleRandom {

    static Integer minRange = 1;

    static Integer maxRange = 20;

    @Scheduled(fixedRate = 1000)
    public void generateRandomNumbers() {
        int currentPosition = InitializeTimer.arrayPointer.addAndGet(1);
        InitializeTimer.TIME_STORAGE[currentPosition % InitializeTimer.storageSize] = InitializeTimer.TIME_STORAGE[(currentPosition-1) % InitializeTimer.storageSize] + generateRandomSum();
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
