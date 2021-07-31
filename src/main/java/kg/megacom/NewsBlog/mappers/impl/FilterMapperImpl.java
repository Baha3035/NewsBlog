package kg.megacom.NewsBlog.mappers.impl;

import kg.megacom.NewsBlog.mappers.FilterMapper;
import kg.megacom.NewsBlog.models.dto.FilterDto;
import kg.megacom.NewsBlog.models.entities.Filter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilterMapperImpl implements FilterMapper {
    @Override
    public Filter toEntity(FilterDto dto) {
        Filter filter = new Filter();
        filter.setActive(dto.isActive());
        filter.setId(dto.getId());
        filter.setLang(dto.getLang());
        filter.setName(dto.getName());
        return filter;
    }

    @Override
    public FilterDto toDto(Filter entity) {
        FilterDto filterDto = new FilterDto();
        filterDto.setActive(entity.isActive());
        filterDto.setId(entity.getId());
        filterDto.setLang(entity.getLang());
        filterDto.setName(entity.getName());
        return filterDto;
    }

    @Override
    public List<Filter> toEntities(List<FilterDto> dtoList) {

        return dtoList.stream().map(x->{
            Filter filter = new Filter();
            filter.setActive(x.isActive());
            filter.setId(x.getId());
            filter.setLang(x.getLang());
            filter.setName(x.getName());
            return filter;
        }).collect(Collectors.toList());
    }

    @Override
    public List<FilterDto> toDtos(List<Filter> entities) {

        return entities.stream().map(x->{
            FilterDto filterDto = new FilterDto();
            filterDto.setActive(x.isActive());
            filterDto.setId(x.getId());
            filterDto.setLang(x.getLang());
            filterDto.setName(x.getName());
            return filterDto;
        }).collect(Collectors.toList());
    }
}
