package ua.foxminded.domain.pipedriveapi.model.common;

import java.util.List;

public class Person {

    private Long id;
    private String name;
    private List<Email> email;
    private List<Phone> phone;
    private int owner_id;
    private int value;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public List<Email> getEmail() {
        return email;
    }

    public void setEmail(final List<Email> email) {
        this.email = email;
    }

    public List<Phone> getPhone() {
        return phone;
    }

    public void setPhone(final List<Phone> phone) {
        this.phone = phone;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(final int owner_id) {
        this.owner_id = owner_id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(final int value) {
        this.value = value;
    }
}
