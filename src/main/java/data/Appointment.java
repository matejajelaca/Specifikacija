package data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Appointment {
    private LocalDate date;
    private LocalTime start;
    private LocalTime end;

    public Appointment(LocalDate date, LocalTime start, long minute) {
        this.date = date;
        this.start = start;
        this.end = start.plus(minute, ChronoUnit.MINUTES);
    }

    public static List<Appointment> getAppointments(DayOfWeek dayOfWeek, LocalTime start, LocalTime end, LocalDate startPeriod, LocalDate endPeriod){
        List<Appointment> appointments = new ArrayList<>();
        startPeriod = startPeriod.with(TemporalAdjusters.next(dayOfWeek));
        for(LocalDate date=startPeriod;date.isBefore(endPeriod);date=date.minusWeeks(1)){
            appointments.add(new Appointment(date,start,end));
        }
        return appointments;
    }
}
