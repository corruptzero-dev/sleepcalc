package ru.corruptzero.sleepcalc.service;

import java.time.LocalTime;
import java.util.List;

public interface TimeService {
    List<LocalTime> getSleepTimeList(LocalTime time);
    List<LocalTime> getSleepTimeList();
}
