package data.properties;

import data.Property;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class NumberOfComputer implements Property {

    private int numberOfComputers;

    public NumberOfComputer(){
        numberOfComputers = 0;
    }

    @Override
    public boolean criteriaMatched(Property property) {
        if(!(property instanceof  NumberOfComputer))
            return false;

        return numberOfComputers >= ((NumberOfComputer)property).numberOfComputers;
    }

    @Override
    public String toString() {
        if(numberOfComputers>0)
            return String.valueOf(numberOfComputers);
        return "Not available";
    }
}
