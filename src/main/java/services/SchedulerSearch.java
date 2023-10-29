package services;

import data.Property;
import data.Scheduler;
import data.SchedulerItem;

import java.util.List;

public interface SchedulerSearch {
    List<SchedulerItem> getOccupiedAppointments(Scheduler scheduler, String propertyName, Property property);
}
