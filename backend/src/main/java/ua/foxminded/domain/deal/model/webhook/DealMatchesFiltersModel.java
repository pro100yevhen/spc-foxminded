package ua.foxminded.domain.deal.model.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class DealMatchesFiltersModel {

    @JsonProperty("current")
    private List<String> current;

    @JsonProperty("previous")
    private List<String> previous;

    public List<String> getCurrent() {
        return current;
    }

    public void setCurrent(final List<String> current) {
        this.current = current;
    }

    public List<String> getPrevious() {
        return previous;
    }

    public void setPrevious(final List<String> previous) {
        this.previous = previous;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final DealMatchesFiltersModel that = (DealMatchesFiltersModel) o;
        return Objects.equals(current, that.current) && Objects.equals(previous, that.previous);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getClass());
    }

    @Override
    public String toString() {
        return "DealMatchesFiltersModel{" +
                "current=" + current +
                ", previous=" + previous +
                '}';
    }
}
