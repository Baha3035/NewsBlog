package kg.megacom.NewsBlog.mappers;

import kg.megacom.NewsBlog.models.dto.FilterDto;
import kg.megacom.NewsBlog.models.dto.NewsDetailDto;
import kg.megacom.NewsBlog.models.entities.Filter;
import kg.megacom.NewsBlog.models.entities.NewsDetail;

import java.util.List;

public interface FilterMapper {
    Filter toEntity(FilterDto dto);
    FilterDto toDto(Filter entity);

    List<Filter> toEntities(List<FilterDto> dtoList);
    List<FilterDto> toDtos(List<Filter> entities);
}
