package kg.megacom.NewsBlog.services;

import kg.megacom.NewsBlog.models.dto.ImageDto;

import java.util.List;

public interface ImageService {
    List<ImageDto> findByNewsDetailId(Long id);


    ImageDto save(ImageDto imageDto);

    List<ImageDto> findAll();
}
