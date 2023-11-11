package data.importexport;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Configuration {
    private List<ConfigurationItemProperty> properties;
    // imamo mapu imena hedera koje treba da spojimo sa svim poljima u space i u periodu
    private ConfigurationItem spaceConfig;
    private ConfigurationTimePeriod timePeriodConfig;


}
