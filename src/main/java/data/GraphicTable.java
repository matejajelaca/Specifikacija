package data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GraphicTable implements Property{

    private boolean hasGraphicTable;

    public GraphicTable() {
        hasGraphicTable = false;
    }

    @Override
    public boolean criteriaMatched(Property property) {
        if(!(property instanceof  GraphicTable))
            return false;

        return hasGraphicTable == ((GraphicTable)property).hasGraphicTable;
    }

    @Override
    public String toString() {
        if(hasGraphicTable)
            return "Yes";
        return "No";
    }
}
