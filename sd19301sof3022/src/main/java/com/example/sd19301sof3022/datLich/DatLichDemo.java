package com.example.sd19301sof3022.datLich;

import org.slf4j.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DatLichDemo {

    private static final Logger log = LoggerFactory.getLogger(DatLichDemo.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 1000000)
    public void reportCurrentTime() {

        log.info("The time is now {}", dateFormat.format(new Date()));
    }
}