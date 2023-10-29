package data.properties;

import data.Property;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ClassType implements Property {

    private ClassTypeE classType;
    @Override
    public boolean criteriaMatched(Property property) {
        if(!(property instanceof ClassType classType))
            return false;

        return classType.classType.name().equalsIgnoreCase(this.classType.name());
    }
}
