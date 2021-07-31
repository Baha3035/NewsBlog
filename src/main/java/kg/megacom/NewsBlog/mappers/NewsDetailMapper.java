package kg.megacom.NewsBlog.mappers;

import kg.megacom.NewsBlog.models.dto.NewsDetailDto;
import kg.megacom.NewsBlog.models.entities.NewsDetail;

import java.util.List;

public interface NewsDetailMapper {
    NewsDetail toEntity(NewsDetailDto dto);
    NewsDetailDto toDto(NewsDetail entity);

    List<NewsDetail> toEntities(List<NewsDetailDto> dtoList);
    List<NewsDetailDto> toDtos(List<NewsDetail> entities);
}
