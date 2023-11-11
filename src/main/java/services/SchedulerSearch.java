package services;

import data.Property;
import data.Scheduler;
import data.SchedulerItem;
import data.TimePeriod;
import services.requests.OccupiedTimeRequest;
import services.requests.TimeRequest;

import java.util.List;
import java.util.Map;

public interface SchedulerSearch {
    List<SchedulerItem> getOccupiedAppointments(Scheduler scheduler, String propertyName, Property property);
    // prima timerequest da nam korisnik da zeljeno trajanje moguceg termina koji zeli da zakaze kod tog propertija
    List<TimePeriod> getFreeAppointments(Scheduler scheduler, String propertyName, Property property, TimeRequest timeRequest);
    List<TimePeriod> getFreeAppointments(Scheduler scheduler, Map<String,Property> properties, TimeRequest timeRequest);

    List<SchedulerItem> getOccupiedAppointments(Scheduler scheduler, Map<String,Property> properties, OccupiedTimeRequest timeRequest);

    List<SchedulerItem> getOccupiedAppointments(Scheduler scheduler, Map<String,Property> properties);

}
