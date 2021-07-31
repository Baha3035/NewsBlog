package kg.megacom.NewsBlog.services.impl;


import kg.megacom.NewsBlog.dao.NewsDetailRepo;
import kg.megacom.NewsBlog.mappers.NewsDetailMapper;
import kg.megacom.NewsBlog.models.dto.NewsDetailDto;
import kg.megacom.NewsBlog.services.NewsDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsDetailService {
    @Autowired
    private NewsDetailRepo newsDetailRepo;
    @Autowired
    private NewsDetailMapper newsDetailMapper;
    @Override
    public List<NewsDetailDto> findAll() {
        return newsDetailMapper.toDtos(newsDetailRepo.findAll());
    }
}
