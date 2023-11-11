package services.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class OccupiedTimeRequest {
    private LocalDateTime start;
    private LocalDateTime end;

    public OccupiedTimeRequest(LocalDateTime start) {
        this.start = start;
        this.end = start.plusDays(1).toLocalDate().atStartOfDay();
    }
}
