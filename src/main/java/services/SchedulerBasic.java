package services;

import data.*;
import exceptions.MandatoryPropertyException;
import exceptions.OccupiedException;

import java.util.Map;

public interface SchedulerBasic {

    void addRoom(Scheduler scheduler, Space room);
    void addRoom(Scheduler scheduler, Map<String, Property> properties) throws MandatoryPropertyException;
    void addRoom(Scheduler scheduler, String roomName,Map<String, Property> properties) throws MandatoryPropertyException;
    void addRoom(Scheduler scheduler, long capacity, int pcNumber, boolean projector, boolean graphicTable);

    void addScheduleItem(Scheduler scheduler,SchedulerItem schedulerItem) throws OccupiedException;

    void deleteScheduleItem(Scheduler scheduler, SchedulerItem schedulerItem);

    void moveScheduleItem(Scheduler scheduler, SchedulerItem schedulerItem, TimePeriod newTimePeriod) throws OccupiedException;

    void moveScheduleItem(Scheduler scheduler, SchedulerItem schedulerItem, Space space) throws OccupiedException;

    boolean isOccupied(Scheduler scheduler, SchedulerItem schedulerItem);
}
