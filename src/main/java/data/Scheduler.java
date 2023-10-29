package data;

import exceptions.OccupiedException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class Scheduler {

    private List<Space> rooms;
    //zauzeti termini
    private List<SchedulerItem> schedulerItems;
}
