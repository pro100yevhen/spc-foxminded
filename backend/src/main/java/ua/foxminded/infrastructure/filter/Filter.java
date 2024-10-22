package ua.foxminded.infrastructure.filter;

import org.springframework.stereotype.Component;

@Component
public interface Filter<T> {
    boolean apply(T item);
}
