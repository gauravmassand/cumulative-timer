package com.cumulative.timer.cumulative.timer.controller;


import com.cumulative.timer.cumulative.timer.service.CumulativeTimerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CumulativeController {

    Logger logger = LoggerFactory.getLogger(CumulativeController.class);

    @Autowired
    CumulativeTimerService cumulativeTimerService;

    @GetMapping("/getData")
    public String getData() {
        logger.info("Fetching data");
        String response =  cumulativeTimerService.getData();
        logger.info("Fetching data completed");
        return response;
    }

}
