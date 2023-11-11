package services.importexport;

import data.Property;
import data.Scheduler;
import data.importexport.Configuration;
import data.importexport.ConfigurationItem;
import data.importexport.ConfigurationItemProperty;
import exceptions.MandatoryPropertyException;
import services.ImportExport;

import java.io.FileNotFoundException;
import java.io.FileReader;

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
}
