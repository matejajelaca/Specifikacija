package data.properties;

import data.Property;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Capacity implements Property {
    private long capacity;

    public Capacity() {
        capacity = 5;
    }

    @Override
    public boolean criteriaMatched(Property property) {
        if(!(property instanceof  Capacity))
            return false;

        return capacity >= ((Capacity)property).capacity;
    }

    @Override
    public String toString() {
        return String.valueOf(capacity);
    }
}

