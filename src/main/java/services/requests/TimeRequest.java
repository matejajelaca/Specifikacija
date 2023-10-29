package services.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class TimeRequest {
    private LocalDate date;
    private int minutes;
}
