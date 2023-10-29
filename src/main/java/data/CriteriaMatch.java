package data;

import java.util.Map;

public interface CriteriaMatch {
    boolean isCriteriaMatched(Map<String, Property> criteria);
    boolean isCriteriaMatched(String name, Property property);
}
