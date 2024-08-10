package ua.foxminded.domain.activity.model.event;

import java.util.List;

public class MatchesFiltersEventModel {

    private List<Object> current;

    public List<Object> getCurrent() {
        return current;
    }

    public void setCurrent(final List<Object> current) {
        this.current = current;
    }
}
