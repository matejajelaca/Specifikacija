package data.properties;

import data.Property;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Professor implements Property {

    private String nameLastname;
    @Override
    public boolean criteriaMatched(Property property) {
        if(!(property instanceof  Professor professor))
            return false;

        return professor.nameLastname.equalsIgnoreCase(this.nameLastname);
    }
}
