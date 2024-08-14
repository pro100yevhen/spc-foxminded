package ua.foxminded.domain.activity.model.event;

import java.util.List;
import java.util.Objects;

public class MatchesFiltersEventModel {

    private List<Object> current;

    public List<Object> getCurrent() {
        return current;
    }

    public void setCurrent(final List<Object> current) {
        this.current = current;
    }

    @Override
    public String toString() {
        return "MatchesFiltersEventModel{" +
                "current=" + current +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final MatchesFiltersEventModel that = (MatchesFiltersEventModel) o;
        return Objects.equals(current, that.current);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getClass());
    }
}
