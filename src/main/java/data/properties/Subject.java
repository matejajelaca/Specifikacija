package data.properties;

import data.Property;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Subject implements Property {

    private String subject;
    @Override
    public boolean criteriaMatched(Property property) {
        if(!(property instanceof  Subject subject))
            return false;

        return subject.subject.equalsIgnoreCase(this.subject);
    }
}
