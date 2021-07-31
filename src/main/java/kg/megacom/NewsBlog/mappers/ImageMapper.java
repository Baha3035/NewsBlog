package kg.megacom.NewsBlog.mappers;


import kg.megacom.NewsBlog.models.dto.ImageDto;
import kg.megacom.NewsBlog.models.entities.Filter;
import kg.megacom.NewsBlog.models.entities.Image;

import java.util.List;

public interface ImageMapper {
    Image toEntity(ImageDto imageDto);
    ImageDto toDto (Image image);

    List<Image> toEntities(List<ImageDto> imageDtos);
    List<ImageDto> toDtos(List<Image> images);
}
