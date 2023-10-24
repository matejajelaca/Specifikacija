package data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Projector implements Property{

    private boolean hasProjector;

    public Projector(){
        hasProjector = false;
    }

    @Override
    public boolean criteriaMatched(Property property) {
        if(!(property instanceof  Projector))
            return false;

        return hasProjector == ((Projector)property).hasProjector;
    }

    @Override
    public String toString() {
        if(hasProjector)
            return "Yes";
        return "No";
    }
}

