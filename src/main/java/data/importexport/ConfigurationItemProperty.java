package data.importexport;

import data.Property;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConfigurationItemProperty extends ConfigurationItem {
    private Property property;
    private boolean space;

    public ConfigurationItemProperty(String colName, int index, Property property) {
        super(colName,index);
        this.property = property;
        this.space = false;
    }

    public ConfigurationItemProperty(String colName, int index, Property property, boolean space) {
        super(colName, index);
        this.property = property;
        this.space = space;
    }
}
