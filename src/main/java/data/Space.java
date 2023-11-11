package data;

import data.properties.Capacity;
import data.properties.GraphicTable;
import data.properties.NumberOfComputer;
import data.properties.Projector;
import exceptions.MandatoryPropertyException;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

// broj racunara imamo 30 racunara
// da li zadovoljava broj racunara 20 racunara
// u implementaciji ako je this.brojracunara>property.brojracunara return true
// grupe lista grupa
// da li ima grupa 500,200,301


@Setter
@Getter
public class Space implements CriteriaMatch {
    private Map<String,Property> properties;
    private String classroomName;
    public static final Set<String> mandatoryProperties;

    static {
        mandatoryProperties = new HashSet<>();
        mandatoryProperties.add(Properties.CAPACITY);
        mandatoryProperties.add(Properties.GRAPHIC_TABLE);
        mandatoryProperties.add(Properties.NUMBER_OF_COMPUTER);
        mandatoryProperties.add(Properties.PROJECTOR);
    }

    public Space(String classroomName,Map<String, Property> properties) throws MandatoryPropertyException {
        this.classroomName = classroomName;
        this.properties = properties;
        long count = properties.values().stream()
                .filter(propertie-> mandatoryProperties.contains(propertie.getClass().getName().toLowerCase()))
                .count();
        if(count<4){
            throw new MandatoryPropertyException();
        }
    }

    public Space(String classroomName) {
        properties = new HashMap<>();
        properties.put(Properties.CAPACITY,new Capacity());
        properties.put(Properties.GRAPHIC_TABLE,new GraphicTable());
        properties.put(Properties.NUMBER_OF_COMPUTER,new NumberOfComputer());
        properties.put(Properties.PROJECTOR,new Projector());
    }

    public Space(String classroomName,long capacity, int pcNumber, boolean projector, boolean graphicTable) {
        properties = new HashMap<>();
        properties.put(Properties.CAPACITY,new Capacity(capacity));
        properties.put(Properties.GRAPHIC_TABLE,new GraphicTable(graphicTable));
        properties.put(Properties.NUMBER_OF_COMPUTER,new NumberOfComputer(pcNumber));
        properties.put(Properties.PROJECTOR,new Projector(projector));
    }

    public void addProperty(String name,Property property){
        this.properties.put(name,property);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Space space = (Space) o;
        return classroomName.equalsIgnoreCase(space.classroomName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classroomName);
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

    @Override
    public boolean isCriteriaMatched(Map<String, Property> criteria) {
        for(String key: criteria.keySet()){
            if(!isCriteriaMatched(key,criteria.get(key)))
                return false;
        }
        return true;
    }

    @Override
    public boolean isCriteriaMatched(String name, Property property) {
        return properties.containsKey(name) && properties.get(name).criteriaMatched(property);
    }

    public static final class Properties{
        public static final String CAPACITY = "capacity";
        public static final String PROJECTOR = "projector";
        public static final String NUMBER_OF_COMPUTER = "numberOfComputer";
        public static final String GRAPHIC_TABLE = "graphicTable";
        public static final String CLASSROOM = "classRoom";
    }
}
