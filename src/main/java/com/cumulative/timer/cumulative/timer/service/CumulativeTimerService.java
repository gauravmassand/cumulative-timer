package com.cumulative.timer.cumulative.timer.service;


import com.cumulative.timer.cumulative.timer.initializer.InitializeTimer;
import com.cumulative.timer.cumulative.timer.model.ResponseObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CumulativeTimerService {

    Logger logger = LoggerFactory.getLogger(CumulativeTimerService.class);

    public String getData() {
        logger.info("computing data");
        int currentPointer = InitializeTimer.arrayPointer.get();
        ResponseObject responseObject = new ResponseObject();
        responseObject.setFiveMinutes(computeDiffInterval(currentPointer,5));
        responseObject.setTenMinutes(computeDiffInterval(currentPointer,10));
        responseObject.setThirtyMinutes(computeDiffInterval(currentPointer,30));
        logger.info("computation data completed");
        return parseObjectToString(responseObject);
    }

    public String computeDiffInterval(int currentPointer, int timeInterval) {
        timeInterval = timeInterval * 60;
        if(currentPointer - timeInterval <= 0) {
            logger.info("current pointer  {} is less than timerInterval {}, returning NA", currentPointer, timeInterval);
            return "NA";
        }
        int prevPointer = (currentPointer - timeInterval) % InitializeTimer.storageSize;
        return Integer.toString(InitializeTimer.TIME_STORAGE[currentPointer%InitializeTimer.storageSize] - InitializeTimer.TIME_STORAGE[prevPointer]);
    }

    public String parseObjectToString(ResponseObject responseObject) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonOutput = null;
        try {
             jsonOutput = mapper.writeValueAsString(responseObject);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonOutput;
    }
}
