package kg.megacom.NewsBlog.services;

import kg.megacom.NewsBlog.models.dto.ImageDto;
import kg.megacom.NewsBlog.models.inputNewsDetails.InputImageDto;

import java.util.List;

public interface ImageService {
    List<ImageDto> findByNewsDetailId(Long id);


    ImageDto save(ImageDto imageDto);

    List<ImageDto> findAll();

    ImageDto update(Long id, InputImageDto inputImageDto);

    ImageDto saveInputImageDto(InputImageDto inputImageDto, Long newsDetailId);
}
