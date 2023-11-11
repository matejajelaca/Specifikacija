package services.importexport;

import data.Scheduler;
import data.SchedulerItem;
import data.Space;
import data.TimePeriod;
import data.importexport.Configuration;
import exceptions.MandatoryPropertyException;

import java.io.FileReader;

public abstract class Parser {

    public abstract Scheduler parse(FileReader fileReader, Configuration configuration) throws MandatoryPropertyException;

    public abstract SchedulerItem parse(Configuration configuration, Object object) throws MandatoryPropertyException;
    public abstract Space parseRoom(Configuration configuration, Object object) throws MandatoryPropertyException;
    public abstract TimePeriod parseTimePeriod(Configuration configuration, Object object) ;
}
