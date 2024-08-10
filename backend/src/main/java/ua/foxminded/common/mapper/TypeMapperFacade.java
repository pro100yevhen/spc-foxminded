package ua.foxminded.common.mapper;

import ua.foxminded.common.mapper.exception.TypeMappingException;

import java.util.List;

public interface TypeMapperFacade {

    <S, T> T map(S source, Class<T> targetClz);

    default <S, T> List<T> mapList(final List<S> sourceList, final Class<T> targetClz) {
        assertNotNull(sourceList, targetClz);

        return sourceList
                .stream()
                .map(source -> map(source, targetClz))
                .toList();
    }

    private void assertNotNull(final List<?> list, final Class<?> targetClz) {
        if (list == null) {
            throw new TypeMappingException("Fail to convert list of values: source list can not be null");
        }
        if (targetClz == null) {
            throw new TypeMappingException("Fail to convert list of values: target class can not be null");
        }
    }
}