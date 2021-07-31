package kg.megacom.NewsBlog.services.impl;

import kg.megacom.NewsBlog.dao.ImageRepo;
import kg.megacom.NewsBlog.mappers.ImageMapper;
import kg.megacom.NewsBlog.models.dto.ImageDto;
import kg.megacom.NewsBlog.services.ImageService;
import kg.megacom.NewsBlog.services.NewsDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    ImageRepo imageRepo;
    @Autowired
    ImageMapper imageMapper;
    @Autowired
    NewsDetailService newsDetailService;
    @Override
    public List<ImageDto> findByNewsDetailId(Long id) {
            return imageMapper.toDtos(imageRepo.findByNewsDetailId(id));
        }

    @Override
    public ImageDto save(ImageDto imageDto) {
        return imageMapper.toDto(imageRepo.save(imageMapper.toEntity(imageDto)));
    }

    @Override
    public List<ImageDto> findAll() {
        return imageMapper.toDtos(imageRepo.findAll());
    }
}
