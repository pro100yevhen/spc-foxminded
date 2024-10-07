package ua.foxminded.domain.pipedriveapi.model.deal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LastActivity {

    private int id;

    @JsonProperty("due_date")
    private String dueDate;
    private String subject;
    private boolean done;

    @JsonProperty("person_id")
    private int personId;

    @JsonProperty("deal_id")
    private int dealId;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(final String dueDate) {
        this.dueDate = dueDate;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(final String subject) {
        this.subject = subject;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(final boolean done) {
        this.done = done;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(final int personId) {
        this.personId = personId;
    }

    public int getDealId() {
        return dealId;
    }

    public void setDealId(final int dealId) {
        this.dealId = dealId;
    }
}
