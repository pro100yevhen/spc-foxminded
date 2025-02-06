package ua.foxminded.domain.pipedriveapi.model.deal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DealPipedriveApi {

    private boolean success;
    private DealApiData data;

    @JsonProperty("additional_data")
    private AdditionalData additionalData;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(final boolean success) {
        this.success = success;
    }

    public DealApiData getData() {
        return data;
    }

    public void setData(final DealApiData data) {
        this.data = data;
    }

    public AdditionalData getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(final AdditionalData additionalData) {
        this.additionalData = additionalData;
    }
}
