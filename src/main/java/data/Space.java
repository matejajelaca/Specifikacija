package data;

import exceptions.MandatoryPropertyException;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// broj racunara imamo 30 racunara
// da li zadovoljava broj racunara 20 racunara
// u implementaciji ako je this.brojracunara>property.brojracunara return true
// grupe lista grupa
// da li ima grupa 500,200,301


@Setter
@Getter
public class Space {
    private Map<String,Property> properties;

    public Space(Map<String, Property> properties) throws MandatoryPropertyException {
        this.properties = properties;
        Set<String> mandatory = new HashSet<>();
        mandatory.add("capacity");
        mandatory.add("graphictable");
        mandatory.add("numberofcomputer");
        mandatory.add("projector");
        long count = properties.values().stream()
                .filter(propertie-> mandatory.contains(propertie.getClass().getName().toLowerCase()))
                .count();
        if(count<4){
            throw new MandatoryPropertyException();
        }
    }

    public Space() {
        properties = new HashMap<>();
        properties.put("capacity",new Capacity());
        properties.put("graphicTable",new GraphicTable());
        properties.put("numberOfComputer",new NumberOfComputer());
        properties.put("projector",new Projector());
    }

    public Space(long capacity, int pcNumber, boolean projector, boolean graphicTable) {
        properties = new HashMap<>();
        properties.put("capacity",new Capacity(capacity));
        properties.put("graphicTable",new GraphicTable(graphicTable));
        properties.put("numberOfComputer",new NumberOfComputer(pcNumber));
        properties.put("projector",new Projector(projector));
    }

    public void addProperty(String name,Property property){
        this.properties.put(name,property);
    }

    public boolean isMatched(Map<String, Property> criteria){
        for(String key: criteria.keySet()){
            if(!properties.containsKey(key) || !properties.get(key).criteriaMatched(criteria.get(key))){
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(String key : properties.keySet()){
            stringBuilder.append(key).append(": ").append(properties.get(key).toString()).append(",");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }
}
