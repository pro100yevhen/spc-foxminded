package ua.foxminded.domain.pipedriveapi.model.activity;

import ua.foxminded.domain.pipedriveapi.model.common.Person;
import ua.foxminded.domain.pipedriveapi.model.common.User;

import java.util.Map;

public class RelatedObjects {

    private Map<String, User> user;
    private Map<String, Person> person;
    private Map<String, Deal> deal;

    public Map<String, User> getUser() {
        return user;
    }

    public void setUser(final Map<String, User> user) {
        this.user = user;
    }

    public Map<String, Person> getPerson() {
        return person;
    }

    public void setPerson(final Map<String, Person> person) {
        this.person = person;
    }

    public Map<String, Deal> getDeal() {
        return deal;
    }

    public void setDeal(final Map<String, Deal> deal) {
        this.deal = deal;
    }
}
