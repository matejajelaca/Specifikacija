package services;

import data.Property;
import data.Scheduler;
import data.importexport.ConfigurationItem;
import data.importexport.ConfigurationItemProperty;
import exceptions.MandatoryPropertyException;
import services.importexport.Parser;

import java.io.FileNotFoundException;

public interface ImportExport {
    void addColumn(ConfigurationItemProperty property);
    void addColumnSpace(ConfigurationItem space);
    void addSpacePropertie(String columnName,int index, Property property);
    Scheduler importFromFile(String fileName, Parser parser) throws FileNotFoundException, MandatoryPropertyException;


}
