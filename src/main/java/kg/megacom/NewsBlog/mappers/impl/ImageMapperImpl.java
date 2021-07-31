package kg.megacom.NewsBlog.mappers.impl;

import kg.megacom.NewsBlog.mappers.ImageMapper;
import kg.megacom.NewsBlog.mappers.NewsDetailMapper;
import kg.megacom.NewsBlog.models.dto.ImageDto;
import kg.megacom.NewsBlog.models.entities.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ImageMapperImpl implements ImageMapper {
    @Autowired
    private NewsDetailMapper newsDetailMapper;

    @Override
    public Image toEntity(ImageDto imageDto) {
        Image image = new Image();
        image.setActive(imageDto.isActive());
        image.setId(imageDto.getId());
        image.setOrderNum(imageDto.getOrderNum());
        image.setUrl(imageDto.getUrl());
        image.setNewsDetail(newsDetailMapper.toEntity(imageDto.getNewsDetailDto()));
        return image;
    }

    @Override
    public ImageDto toDto(Image image) {

        ImageDto imageDto = new ImageDto();
        imageDto.setActive(image.isActive());
        imageDto.setId(image.getId());
        imageDto.setNewsDetailDto(newsDetailMapper.toDto(image.getNewsDetail()));
        imageDto.setUrl(image.getUrl());
        imageDto.setOrderNum(image.getOrderNum());

        return imageDto;
    }

    @Override
    public List<Image> toEntities(List<ImageDto> imageDtos) {

        return imageDtos.stream()
                .map(x->{
                    Image image = new Image();
                    image.setActive(x.isActive());
                    image.setId(x.getId());
                    image.setOrderNum(x.getOrderNum());
                    image.setUrl(x.getUrl());
                    image.setNewsDetail(newsDetailMapper.toEntity(x.getNewsDetailDto()));
                    return image;
                }).collect(Collectors.toList());
    }

    @Override
    public List<ImageDto> toDtos(List<Image> images) {
        return images.stream().map(x->{
            ImageDto imageDto = new ImageDto();
            imageDto.setActive(x.isActive());
            imageDto.setId(x.getId());
            imageDto.setNewsDetailDto(newsDetailMapper.toDto(x.getNewsDetail()));
            imageDto.setUrl(x.getUrl());
            imageDto.setOrderNum(x.getOrderNum());
            return imageDto;
        }).collect(Collectors.toList());
    }
}
