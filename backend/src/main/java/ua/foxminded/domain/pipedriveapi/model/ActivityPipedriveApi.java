package ua.foxminded.domain.pipedriveapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ActivityPipedriveApi {

    private boolean success;
    private Data data;
    @JsonProperty("related_objects")
    private RelatedObjects relatedObjects;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(final boolean success) {
        this.success = success;
    }

    public Data getData() {
        return data;
    }

    public void setData(final Data data) {
        this.data = data;
    }

    public RelatedObjects getRelatedObjects() {
        return relatedObjects;
    }

    public void setRelatedObjects(final RelatedObjects relatedObjects) {
        this.relatedObjects = relatedObjects;
    }
}
