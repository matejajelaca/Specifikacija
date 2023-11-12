package services.importexport;

import data.Property;
import data.Scheduler;
import data.SchedulerItem;
import data.importexport.Configuration;
import data.importexport.ConfigurationItem;
import data.importexport.ConfigurationItemProperty;
import exceptions.MandatoryPropertyException;
import services.ImportExport;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ImportExportService implements ImportExport {

    private Configuration  configuration;

    @Override
    public void addColumn(ConfigurationItemProperty property) {

    }

    @Override
    public void addColumnSpace(ConfigurationItem space) {

    }

    @Override
    public void addSpacePropertie(String columnName, int index, Property property) {

    }

    @Override
    public Scheduler importFromFile(String fileName, Parser parser) throws FileNotFoundException, MandatoryPropertyException {
        return parser.parse(new FileReader(fileName), configuration);
    }

    @Override
    public void export(String fileName, Parser parser, Scheduler scheduler) throws FileNotFoundException, MandatoryPropertyException {
        File file = new File(fileName);
        try {
            file.createNewFile();
            parser.writeInto(file,configuration, scheduler);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
