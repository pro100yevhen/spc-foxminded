package ua.foxminded.domain.activity.model.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class WebhookActivityModel {

    private Long v;

    @JsonProperty("matches_filters")
    private ActivityMatchesFiltersModel matchesFilters;
    private ActivityMetaModel meta;
    private ActivityDetailsModel current;
    private ActivityDetailsModel previous;
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

    public ActivityMatchesFiltersModel getMatchesFilters() {
        return matchesFilters;
    }

    public void setMatchesFilters(final ActivityMatchesFiltersModel matchesFilters) {
        this.matchesFilters = matchesFilters;
    }

    public ActivityMetaModel getMeta() {
        return meta;
    }

    public void setMeta(final ActivityMetaModel meta) {
        this.meta = meta;
    }

    public ActivityDetailsModel getCurrent() {
        return current;
    }

    public void setCurrent(final ActivityDetailsModel current) {
        this.current = current;
    }

    public ActivityDetailsModel getPrevious() {
        return previous;
    }

    public void setPrevious(final ActivityDetailsModel previous) {
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

        final WebhookActivityModel that = (WebhookActivityModel) o;
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
