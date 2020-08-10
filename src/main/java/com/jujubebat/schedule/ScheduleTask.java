package com.jujubebat.schedule;

import com.jujubebat.service.GetApiData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;

@Component
public class ScheduleTask {

    @Autowired
    GetApiData getApiData;

    @Scheduled(fixedDelay = 2000)
    public void task1() throws UnsupportedEncodingException, URISyntaxException {
        System.out.println("api 호출완료" + LocalDateTime.now());
        getApiData.GetData();
    }
}
