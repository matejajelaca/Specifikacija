package data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

@AllArgsConstructor
@Getter
@Setter
public abstract class TimePeriod {
    private LocalTime start;
    private LocalTime end;

    public TimePeriod(LocalTime start, long minute) {
        this.start = start;
        this.end = start.plus(minute, ChronoUnit.MINUTES);
    }

    public abstract boolean isOverlap(TimePeriod t2);
    // da proverimo da li overlapuje sa date
    // i da li overlapuje sa danom u nedelji u periodu od startDate i endDate

//    public static List<TimePeriod> getAppointments(DayOfWeek dayOfWeek, LocalTime start, LocalTime end, LocalDate startPeriod, LocalDate endPeriod){
//        List<TimePeriod> appointments = new ArrayList<>();
//        startPeriod = startPeriod.with(TemporalAdjusters.next(dayOfWeek));
//        for(LocalDate date=startPeriod;date.isBefore(endPeriod);date=date.minusWeeks(1)){
//            appointments.add(new TimePeriod(date,start,end));
//        }
//        return appointments;
//    }
}
