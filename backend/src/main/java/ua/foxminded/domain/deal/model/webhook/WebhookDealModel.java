package ua.foxminded.domain.deal.model.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WebhookDealModel {

    @JsonProperty("data")
    private DealDataModel data;

    @JsonProperty("previous")
    private DealDetailsModel previous;

    @JsonProperty("meta")
    private DealMetaModel meta;

    private Long retry;
    private String event;

    public DealDataModel getData() {
        return data;
    }

    public void setData(final DealDataModel data) {
        this.data = data;
    }

    public DealDetailsModel getPrevious() {
        return previous;
    }

    public void setPrevious(final DealDetailsModel previous) {
        this.previous = previous;
    }

    public DealMetaModel getMeta() {
        return meta;
    }

    public void setMeta(final DealMetaModel meta) {
        this.meta = meta;
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
