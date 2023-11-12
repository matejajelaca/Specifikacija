package services.importexport;

import data.*;
import data.importexport.Configuration;
import data.importexport.ConfigurationItem;
import data.importexport.ConfigurationItemProperty;
import exceptions.MandatoryPropertyException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public abstract class JsonParser extends Parser{
    @Override
    public Scheduler parse(FileReader fileReader, Configuration configuration) throws MandatoryPropertyException {

        try {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            Scheduler scheduler = new Scheduler();

            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }

            String jsonString = stringBuilder.toString();
            JSONArray jsonArray = new JSONArray(jsonString);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                scheduler.getRooms().add(parseRoom(configuration,jsonObject));
                scheduler.getSchedulerItems().add(parse(configuration,jsonObject));
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Space parseRoom(Configuration configuration, Object object){
        JSONObject jsonObject = (JSONObject)object;
        Space space = new Space(jsonObject.getString(configuration.getSpaceConfig().getColName()));
        for(ConfigurationItemProperty property: configuration.getProperties()){
            if(property.isSpace()){
                space.addProperty(property.getColName(), property.getProperty());
            }
        }
        return space;
    }

    @Override
    public SchedulerItem parse(Configuration configuration, Object object) throws MandatoryPropertyException{
        JSONObject jsonObject = (JSONObject) object;
        Space space = parseRoom(configuration,jsonObject);
        TimePeriod timePeriod = parseTimePeriod(configuration,object);
        Map<String, Property> properties = new HashMap<>();
        for(ConfigurationItemProperty property: configuration.getProperties()){
            if(!property.isSpace()){
                properties.put(property.getColName(), property.getProperty());
            }
        }
        return new SchedulerItem(timePeriod,space,properties);
    }

    // napravite u configuration items sort tj compareto metodu za sortiranje po indeksu i onda ovde pr vo sortirate po indeksu pa onda prodjete kroz sve konfiguracije i za tu configuraciju ubacujete u json
    @Override
    public void writeInto(File file, Configuration configuration, Scheduler scheduler) {
        for(SchedulerItem schedulerItem: scheduler.getSchedulerItems()){
            JSONObject jsonObject = new JSONObject();
            List<ConfigurationItem> configurationItems = new ArrayList<>(configuration.getProperties());
            configurationItems.addAll(configuration.getTimePeriodConfig().getStartPeriod);
            configurationItems.add(configuration.getSpaceConfig());
            Collections.sort(configurationItems);
            for(ConfigurationItem configurationItem: configurationItems){
                if(configurationItem instanceof ConfigurationItemProperty)
                    jsonObject.put(configurationItem.getColName(),schedulerItem.getProperties().get(configurationItem.getColName()));

                    jsonObject.put(configurationItem.getColName(),schedulerItem.getSpace().getClassroomName());
                    za timeperiod
            }

        }
    }
}
