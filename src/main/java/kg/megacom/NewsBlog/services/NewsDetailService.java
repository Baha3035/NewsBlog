package kg.megacom.NewsBlog.services;

import kg.megacom.NewsBlog.models.dto.NewsDetailDto;

import java.util.List;

public interface NewsDetailService {
    List<NewsDetailDto> findAll();
}