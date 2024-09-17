package ua.foxminded.domain.deal.model.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class WebhookDealModel {

    private Long v;

    @JsonProperty("matches_filters")
    private DealMatchesFiltersModel matchesFilters;
    private DealMetaModel meta;
    private DealDetailsModel current;
    private DealDetailsModel previous;
    private Long retry;
    private String event;

    public Long getV() {
        return v;
    }

    public void setV(final Long v) {
        this.v = v;
    }

    public DealMatchesFiltersModel getMatchesFilters() {
        return matchesFilters;
    }

    public void setMatchesFilters(final DealMatchesFiltersModel matchesFilters) {
        this.matchesFilters = matchesFilters;
    }

    public DealMetaModel getMeta() {
        return meta;
    }

    public void setMeta(final DealMetaModel meta) {
        this.meta = meta;
    }

    public DealDetailsModel getCurrent() {
        return current;
    }

    public void setCurrent(final DealDetailsModel current) {
        this.current = current;
    }

    public DealDetailsModel getPrevious() {
        return previous;
    }

    public void setPrevious(final DealDetailsModel previous) {
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
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final WebhookDealModel that = (WebhookDealModel) o;
        return Objects.equals(v, that.v) && Objects.equals(matchesFilters,
                that.matchesFilters) && Objects.equals(meta, that.meta) && Objects.equals(current,
                that.current) && Objects.equals(previous, that.previous) && Objects.equals(retry,
                that.retry) && Objects.equals(event, that.event);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getClass());
    }

    @Override
    public String toString() {
        return "WebhookDealModel{" +
                "v=" + v +
                ", matchesFilters=" + matchesFilters +
                ", meta=" + meta +
                ", current=" + current +
                ", previous=" + previous +
                ", retry=" + retry +
                ", event='" + event + '\'' +
                '}';
    }
}
