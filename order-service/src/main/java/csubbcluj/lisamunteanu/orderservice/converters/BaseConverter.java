package csubbcluj.lisamunteanu.orderservice.converters;

import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseConverter<Model, Dto> {

    public abstract Dto convertModelToDto(Model model);

    public List<Dto> convertModelListToDTOList(List<Model> models) {
        return models
                .stream()
                .map(this::convertModelToDto)
                .collect(Collectors.toList());
    }

    public abstract Model convertDtoToModel(Dto dto);


    public List<Model> convertDTOListToModelList(List<Dto> models) {
        return models
                .stream()
                .map(this::convertDtoToModel)
                .collect(Collectors.toList());
    }

}

