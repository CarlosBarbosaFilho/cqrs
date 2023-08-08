package br.com.cbgomes.query.mapper;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public final class ConverterDTO<T> {

    private final ModelMapperConfig modelMapperConfig;

    public T convertObject(T objects, Class<T> type) {
        return modelMapperConfig.modelMapper().map(objects, type);
    }

    public List<T> convertListObjects(List<T> objects, Class<T> type) {
        return objects
                .stream()
                .map(response -> new ModelMapper().map(response, type))
                .collect(Collectors.toList());
    }
}

