package ua.foxminded.common.model.dto;

import jakarta.validation.constraints.NotEmpty;

import java.util.Objects;

public class OwnerDto {

    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public @NotEmpty String getName() {
        return name;
    }

    public void setName(@NotEmpty final String name) {
        this.name = name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final OwnerDto owner = (OwnerDto) o;
        return Objects.equals(id, owner.id) && Objects.equals(name, owner.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
