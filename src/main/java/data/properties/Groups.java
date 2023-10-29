package data.properties;

import data.Property;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;
@Setter
@Getter
@AllArgsConstructor
public class Groups implements Property {

    private Set<String> groups;
    @Override
    public boolean criteriaMatched(Property property) {
        if(!(property instanceof  Groups groups))
            return false;

        return this.groups.containsAll(groups.getGroups());
    }
}
