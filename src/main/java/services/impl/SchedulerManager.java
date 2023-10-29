package services.impl;

import data.*;
import exceptions.MandatoryPropertyException;
import exceptions.OccupiedException;
import services.SchedulerBasic;
import services.SchedulerSearch;

import java.util.List;
import java.util.Map;

public class SchedulerManager implements SchedulerBasic, SchedulerSearch {

    public void addRoom(Scheduler scheduler, Space room){
        if (!scheduler.getRooms().contains(room))
            scheduler.getRooms().add(room);
    }

    @Override
    public void addRoom(Scheduler scheduler, Map<String, Property> properties) throws MandatoryPropertyException {
        addRoom(scheduler,new Space(getRoomName(scheduler),properties));
    }

    @Override
    public void addRoom(Scheduler scheduler, String roomName, Map<String, Property> properties) throws MandatoryPropertyException {
        addRoom(scheduler,new Space(roomName,properties));
    }

    @Override
    public void addRoom(Scheduler scheduler, long capacity, int pcNumber, boolean projector, boolean graphicTable) {
        addRoom(scheduler,new Space(getRoomName(scheduler),capacity,pcNumber,projector,graphicTable));
    }

    public void addScheduleItem(Scheduler scheduler, SchedulerItem schedulerItem) throws OccupiedException {
        if(isOccupied(scheduler,schedulerItem))
            throw new OccupiedException();
        scheduler.getSchedulerItems().add(schedulerItem);
    }

    public void deleteScheduleItem(Scheduler scheduler, SchedulerItem schedulerItem){
        scheduler.getSchedulerItems().remove(schedulerItem);
    }

    public void moveScheduleItem(Scheduler scheduler, SchedulerItem schedulerItem, TimePeriod newTimePeriod) throws OccupiedException {
        TimePeriod oldTimePeriod = schedulerItem.getTimePeriod();
        deleteScheduleItem(scheduler,schedulerItem);
        schedulerItem.setTimePeriod(newTimePeriod);
        if(isOccupied(scheduler,schedulerItem)){
            schedulerItem.setTimePeriod(oldTimePeriod);
            addScheduleItem(scheduler,schedulerItem);
            throw new OccupiedException();
        }
        addScheduleItem(scheduler,schedulerItem);
    }

    public void moveScheduleItem(Scheduler scheduler, SchedulerItem schedulerItem, Space space) throws OccupiedException {
        Space oldSpace = schedulerItem.getSpace();
        deleteScheduleItem(scheduler,schedulerItem);
        schedulerItem.setSpace(space);
        // proverimo da li novi space zadovoljava iste kriterijume kao za taj item pa za njegovu ucionicu
        if(isOccupied(scheduler,schedulerItem) || !space.isCriteriaMatched(schedulerItem.getSpace().getProperties())){
            schedulerItem.setSpace(oldSpace);
            addScheduleItem(scheduler,schedulerItem);
            throw new OccupiedException();
        }
        addScheduleItem(scheduler,schedulerItem);
    }

    public boolean isOccupied(Scheduler scheduler, SchedulerItem schedulerItem){
        for(SchedulerItem schedulerItem1:scheduler.getSchedulerItems()){
            if(
                    schedulerItem1.getTimePeriod().isOverlap(schedulerItem.getTimePeriod())
                            && schedulerItem1.getSpace().equals(schedulerItem.getSpace())
            ) return true;
        }
        return false;
    }
    private String getRoomName(Scheduler scheduler){
        return "room".concat(String.valueOf(scheduler.getRooms().size()+1));
    }

    @Override
    public List<SchedulerItem> getOccupiedAppointments(Scheduler scheduler,String propertyName, Property property) {
        return scheduler.getSchedulerItems().stream().
                filter(schedulerItem ->
                        schedulerItem.isCriteriaMatched(propertyName,property)
                ).toList();
    }
}
