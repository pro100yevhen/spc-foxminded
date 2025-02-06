package ua.foxminded.common.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

import java.util.Objects;

@Entity
@Table(name = "owners")
public class Owner extends BaseEntity {

    @Id
    private Long id;

    @Column(name = "name")
    @NotEmpty
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

        final Owner owner = (Owner) o;
        return Objects.equals(id, owner.id) && Objects.equals(name, owner.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
