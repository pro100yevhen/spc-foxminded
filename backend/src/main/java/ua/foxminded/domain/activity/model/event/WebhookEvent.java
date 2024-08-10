package ua.foxminded.domain.activity.model.event;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WebhookEvent {

    private Long v;

    @JsonProperty("matches_filters")
    private MatchesFilters matchesFilters;
    private Meta meta;
    private Activity current;
    private Activity previous;
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

    public MatchesFilters getMatchesFilters() {
        return matchesFilters;
    }

    public void setMatchesFilters(final MatchesFilters matchesFilters) {
        this.matchesFilters = matchesFilters;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(final Meta meta) {
        this.meta = meta;
    }

    public Activity getCurrent() {
        return current;
    }

    public void setCurrent(final Activity current) {
        this.current = current;
    }

    public Activity getPrevious() {
        return previous;
    }

    public void setPrevious(final Activity previous) {
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
}
