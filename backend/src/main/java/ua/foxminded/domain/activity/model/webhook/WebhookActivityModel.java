package ua.foxminded.domain.activity.model.webhook;

public class WebhookActivityModel {

    private ActivityDataModel data;
    private ActivityMetaModel meta;
    private ActivityPreviousModel previous;

    public ActivityDataModel getData() {
        return data;
    }

    public void setData(final ActivityDataModel data) {
        this.data = data;
    }

    public ActivityMetaModel getMeta() {
        return meta;
    }

    public void setMeta(final ActivityMetaModel meta) {
        this.meta = meta;
    }

    public ActivityPreviousModel getPrevious() {
        return previous;
    }

    public void setPrevious(final ActivityPreviousModel previous) {
        this.previous = previous;
    }
}
