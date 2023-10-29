package data;

import exceptions.MandatoryPropertyException;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Setter
@Getter
public class SchedulerItem implements CriteriaMatch {

    private Map<String,Property> properties;
    private TimePeriod timePeriod;
    private Space space;
    public static final Set<String> mandatoryProperties = Collections.unmodifiableSet(new HashSet<>() {
        {
            add(Properties.CLASS_TYPE);
            add(Properties.SUBJECT);
            add(Properties.PROFESSOR);
            add(Properties.GROUPS);
        }
    });

    public SchedulerItem(TimePeriod timePeriod, Space space, Map<String, Property> properties) throws MandatoryPropertyException {
        this.timePeriod = timePeriod;
        this.space = space;
        this.properties = properties;
        long count = properties.values().stream()
                .filter(property-> mandatoryProperties.contains(property.getClass().getName().toLowerCase()))
                .count();
        if(count<4){
            throw new MandatoryPropertyException();
        }
    }

    @Override
    public boolean isCriteriaMatched(Map<String, Property> criteria) {
        for(String key: criteria.keySet()){
            if(!isCriteriaMatched(key,criteria.get(key))){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isCriteriaMatched(String name, Property property) {
        if(!properties.containsKey(name) && space.isCriteriaMatched(name,property))
            return true;
        return properties.containsKey(name) && properties.get(name).criteriaMatched(property);
    }

    //    static {
//        mandatoryProperties = new HashSet<>();
//        mandatoryProperties.add(Properties.CAPACITY);
//        mandatoryProperties.add(Properties.GRAPHIC_TABLE);
//        mandatoryProperties.add(Properties.NUMBER_OF_COMPUTER);
//        mandatoryProperties.add(Properties.PROJECTOR);
//    }
    public static final class Properties{
        public static final String CLASS_TYPE = "classType";
        public static final String GROUPS = "groups";
        public static final String PROFESSOR = "professor";
        public static final String SUBJECT = "subject";
    }

}
