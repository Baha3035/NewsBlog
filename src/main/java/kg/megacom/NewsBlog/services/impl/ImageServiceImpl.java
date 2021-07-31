package kg.megacom.NewsBlog.services.impl;

import kg.megacom.NewsBlog.dao.ImageRepo;
import kg.megacom.NewsBlog.mappers.ImageMapper;
import kg.megacom.NewsBlog.models.dto.ImageDto;
import kg.megacom.NewsBlog.services.ImageService;
import kg.megacom.NewsBlog.services.NewsDetailService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ImageServiceImpl implements ImageService {
    @Autowired
    ImageRepo imageRepo;
    @Autowired
    ImageMapper imageMapper;
    @Autowired
    NewsDetailService newsDetailService;

    @Override
    public List<ImageDto> findIdByNewsDetailId(Long id) {
        return imageMapper.toDtos(imageRepo.findIdByNewsDetailId(id));
    }
}
