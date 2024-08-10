package ua.foxminded.domain.activity.model.event;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserEventModel {

    private String created;

    @JsonProperty("last_login")
    private String lastLogin;

    @JsonProperty("has_pic")
    private Boolean hasPic;

    @JsonProperty("active_flag")
    private boolean activeFlag;

    private String locale;

    @JsonProperty("pic_hash")
    private String picHash;

    @JsonProperty("update_time")
    private String updateTime;

    @JsonProperty("role_id")
    private String roleId;

    private String name;

    @JsonProperty("timezone_name")
    private String timezoneName;

    private String modified;

    private Long id;

    @JsonProperty("default_currency")
    private String defaultCurrency;

    @JsonProperty("add_time")
    private String addTime;

    private String email;

    public String getCreated() {
        return created;
    }

    public void setCreated(final String created) {
        this.created = created;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(final String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Boolean getHasPic() {
        return hasPic;
    }

    public void setHasPic(final Boolean hasPic) {
        this.hasPic = hasPic;
    }

    public boolean isActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(final boolean activeFlag) {
        this.activeFlag = activeFlag;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(final String locale) {
        this.locale = locale;
    }

    public String getPicHash() {
        return picHash;
    }

    public void setPicHash(final String picHash) {
        this.picHash = picHash;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(final String updateTime) {
        this.updateTime = updateTime;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(final String roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getTimezoneName() {
        return timezoneName;
    }

    public void setTimezoneName(final String timezoneName) {
        this.timezoneName = timezoneName;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(final String modified) {
        this.modified = modified;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getDefaultCurrency() {
        return defaultCurrency;
    }

    public void setDefaultCurrency(final String defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(final String addTime) {
        this.addTime = addTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }
}
