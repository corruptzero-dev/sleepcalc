package ru.corruptzero.sleepcalc.contoller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.corruptzero.sleepcalc.service.impl.TimeServiceImpl;

import java.time.LocalTime;
import java.util.List;

@RestController
@Slf4j
public class TimeController {

    @Autowired
    TimeServiceImpl service;

    @GetMapping
    public List<LocalTime> getSleepTimes(@RequestParam(required = false) LocalTime time){
        log.info("GOT TIME: " + time);
        return time==null?service.getSleepTimeList():service.getSleepTimeList(time);
    }
}
