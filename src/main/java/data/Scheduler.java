package data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Scheduler {

    private List<Space> rooms;
    //zauzeti termini
    private List<SchedulerItem> schedulerItems;
}
