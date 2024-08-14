package ua.foxminded.common.mapper.impl;

import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ua.foxminded.common.mapper.DataMapper;
import ua.foxminded.common.mapper.TypeMapperFacade;
import ua.foxminded.common.mapper.exception.TypeMappingException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Component
public class TypeMapperFacadeImpl implements TypeMapperFacade {

    private final List<DataMapper<?, ?>> mappers;

    private final Map<MappingDescriptor, DataMapper<?, ?>> mapperRegistry = new HashMap<>();

    private final ModelMapper modelMapper;

    public TypeMapperFacadeImpl(
            final List<DataMapper<?, ?>> mappers,
            final ModelMapper modelMapper
    ) {
        this.mappers = mappers;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    protected void populateMapperRegistry() {
        for (final DataMapper<?, ?> mapper : mappers) {
            final MappingDescriptor descriptor =
                    new MappingDescriptor(mapper.getSourceClass(), mapper.getTargetClass());
            final DataMapper<?, ?> alreadyRegistered = mapperRegistry.put(descriptor, mapper);

            if (alreadyRegistered != null) {
                throw new TypeMappingException(
                        "Duplicate type mapper found:[%s]->[%s], already registered:[%s], register candidate:[%s]",
                        descriptor.srcClz, descriptor.targetClz, alreadyRegistered.getClass().getSimpleName(),
                        mapper.getClass().getSimpleName()
                );
            }
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public <S, T> T map(final S source, final Class<T> targetClz) {
        assertNotNull(source, targetClz);

        final Class<?> sourceClz = source.getClass();

        try {
            final Optional<DataMapper<?, ?>> mapperOpt = getMapperFor(sourceClz, targetClz);

            if (mapperOpt.isPresent()) {
                final DataMapper<S, T> mapper = (DataMapper<S, T>) mapperOpt.get();
                return mapper.map(source);
            } else {
                return modelMapper.map(source, targetClz);
            }
        } catch (final Exception e) {
            throw new TypeMappingException("Failed to find type converter for:[%s]->[%s] conversion",
                    sourceClz, targetClz
            );
        }
    }

    private Optional<DataMapper<?, ?>> getMapperFor(final Class<?> sourceClz, final Class<?> targetClz) {
        return Optional.ofNullable(mapperRegistry.get(new MappingDescriptor(sourceClz, targetClz)));
    }

    private void assertNotNull(final Object source, final Class<?> targetClz) {
        if (source == null) {
            throw new TypeMappingException("Fail to convert value: source object can not be null");
        }
        if (targetClz == null) {
            throw new TypeMappingException("Fail to convert value: target class can not be null");
        }
    }

    static class MappingDescriptor {

        private final Class<?> srcClz;

        private final Class<?> targetClz;

        MappingDescriptor(final Class<?> srcClz, final Class<?> targetClz) {
            this.srcClz = srcClz;
            this.targetClz = targetClz;
        }

        public static MappingDescriptor forPair(final Class<?> srcClz, final Class<?> targetClz) {
            return new MappingDescriptor(srcClz, targetClz);
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            final MappingDescriptor that = (MappingDescriptor) o;

            return Objects.equals(srcClz, that.srcClz)
                    && Objects.equals(targetClz, that.targetClz);
        }

        @Override
        public int hashCode() {
            return Objects.hash(srcClz, targetClz);
        }
    }
}

