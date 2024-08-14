package ua.foxminded.domain.activity.model.event;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class WebhookActivityEventModel {

    private Long v;

    @JsonProperty("matches_filters")
    private MatchesFiltersEventModel matchesFilters;
    private MetaEventModel meta;
    private ActivityEventModel current;
    private ActivityEventModel previous;
    private Long retry;
    private String event;

    public String getLocalSortingDueDate() {
        return localSortingDueDate;
    }

    public void setLocalSortingDueDate(final String localSortingDueDate) {
        this.localSortingDueDate = localSortingDueDate;
    }

    @JsonProperty("local_sorting_due_date")
    private String localSortingDueDate;


    public Long getV() {
        return v;
    }

    public void setV(final Long v) {
        this.v = v;
    }

    public MatchesFiltersEventModel getMatchesFilters() {
        return matchesFilters;
    }

    public void setMatchesFilters(final MatchesFiltersEventModel matchesFilters) {
        this.matchesFilters = matchesFilters;
    }

    public MetaEventModel getMeta() {
        return meta;
    }

    public void setMeta(final MetaEventModel meta) {
        this.meta = meta;
    }

    public ActivityEventModel getCurrent() {
        return current;
    }

    public void setCurrent(final ActivityEventModel current) {
        this.current = current;
    }

    public ActivityEventModel getPrevious() {
        return previous;
    }

    public void setPrevious(final ActivityEventModel previous) {
        this.previous = previous;
    }

    public Long getRetry() {
        return retry;
    }

    public void setRetry(final Long retry) {
        this.retry = retry;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(final String event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "WebhookActivityEventModel{" +
                "v=" + v +
                ", matchesFilters=" + matchesFilters +
                ", meta=" + meta +
                ", current=" + current +
                ", previous=" + previous +
                ", retry=" + retry +
                ", event='" + event + '\'' +
                ", localSortingDueDate='" + localSortingDueDate + '\'' +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final WebhookActivityEventModel that = (WebhookActivityEventModel) o;
        return Objects.equals(v, that.v) && Objects.equals(matchesFilters,
                that.matchesFilters) && Objects.equals(meta, that.meta) && Objects.equals(current,
                that.current) && Objects.equals(previous, that.previous) && Objects.equals(retry,
                that.retry) && Objects.equals(event, that.event) && Objects.equals(localSortingDueDate,
                that.localSortingDueDate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getClass());
    }
}
