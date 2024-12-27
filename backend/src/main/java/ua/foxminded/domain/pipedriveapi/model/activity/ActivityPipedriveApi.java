package ua.foxminded.domain.pipedriveapi.model.activity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ActivityPipedriveApi {

    private boolean success;
    private AcvitivyApiData acvitivyApiData;
    @JsonProperty("related_objects")
    private RelatedObjects relatedObjects;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(final boolean success) {
        this.success = success;
    }

    public AcvitivyApiData getData() {
        return acvitivyApiData;
    }

    public void setData(final AcvitivyApiData acvitivyApiData) {
        this.acvitivyApiData = acvitivyApiData;
    }

    public RelatedObjects getRelatedObjects() {
        return relatedObjects;
    }

    public void setRelatedObjects(final RelatedObjects relatedObjects) {
        this.relatedObjects = relatedObjects;
    }
}
