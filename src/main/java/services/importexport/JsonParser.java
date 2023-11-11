package services.importexport;

import data.Scheduler;
import data.Space;
import data.importexport.Configuration;
import data.importexport.ConfigurationItemProperty;
import exceptions.MandatoryPropertyException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
    public  Space parseRoom(Configuration configuration, Object object){
        JSONObject jsonObject = (JSONObject)object;
        Space space = new Space(jsonObject.getString(configuration.getSpaceConfig().getColName()));
        for(ConfigurationItemProperty property: configuration.getProperties()){
            if(property.isSpace()){
                space.addProperty(property.getColName(), property.getProperty());
            }
        }
        return space;
    }
}
