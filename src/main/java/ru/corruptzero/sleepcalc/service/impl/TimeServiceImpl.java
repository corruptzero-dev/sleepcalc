package ru.corruptzero.sleepcalc.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.corruptzero.sleepcalc.service.TimeService;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TimeServiceImpl implements TimeService {

    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");

    @Override
    public List<LocalTime> getSleepTimeList(LocalTime time) {
        List<LocalTime> timeList = new ArrayList<>();
        try {
            LocalTime tempTime = time.minusHours(9).minusMinutes(15);
            for (int i = 0; i < 6; i++) {
                timeList.add(LocalTime.parse(tempTime.format(dtf)));
                tempTime = tempTime.plusMinutes(90);
            }
        } catch (Exception e) {
            log.error("EXCEPTION IN TIMESERVICE: " + e.getMessage());
        }
        return timeList;
    }

    @Override
    public List<LocalTime> getSleepTimeList() {
        LocalTime time = LocalTime.now();
        List<LocalTime> timeList = new ArrayList<>();
        try {
            LocalTime tempTime = time.plusHours(9).plusMinutes(15);
            for (int i = 0; i < 6; i++) {
                timeList.add(LocalTime.parse(tempTime.format(dtf)));
                tempTime = tempTime.minusMinutes(90);
            }
        } catch (Exception e) {
            log.error("EXCEPTION IN TIMESERVICE: " + e.getMessage());
        }
        return timeList;
    }

}
