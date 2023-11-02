package services;

import data.Property;
import data.Scheduler;
import data.SchedulerItem;
import data.TimePeriod;
import services.requests.TimeRequest;

import java.util.List;

public interface SchedulerSearch {
    List<SchedulerItem> getOccupiedAppointments(Scheduler scheduler, String propertyName, Property property);
    // prima timerequest da nam korisnik da zeljeno trajanje moguceg termina koji zeli da zakaze kod tog propertija
    List<TimePeriod> getFreeAppointments(Scheduler scheduler, String propertyName, Property property, TimeRequest timeRequest);

}
