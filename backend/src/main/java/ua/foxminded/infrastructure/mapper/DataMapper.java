package ua.foxminded.infrastructure.mapper;

public interface DataMapper<E, D> {

    Class<E> getSourceClass();

    Class<D> getTargetClass();

    D map(E target);
}
