package kg.megacom.NewsBlog.mappers.impl;

import kg.megacom.NewsBlog.mappers.FilterMapper;
import kg.megacom.NewsBlog.mappers.NewsDetailMapper;
import kg.megacom.NewsBlog.models.dto.NewsDetailDto;
import kg.megacom.NewsBlog.models.entities.NewsDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class NewsDetailMapperImpl implements NewsDetailMapper {
    @Autowired
    private FilterMapper filterMapper;
    @Override
    public NewsDetail toEntity(NewsDetailDto dto) {
        NewsDetail newsDetail = new NewsDetail();
        newsDetail.setAddDate(dto.getAddDate());
        newsDetail.setFilter(filterMapper.toEntity(dto.getFilterDto()));
        newsDetail.setEditDate(dto.getEditDate());
        newsDetail.setHeaderTitle(dto.getHeaderTitle());
        newsDetail.setId(dto.getId());
        newsDetail.setLang(dto.getLang());
        newsDetail.setText(dto.getText());
        newsDetail.setTitle(dto.getTitle());
        return newsDetail;
    }

    @Override
    public NewsDetailDto toDto(NewsDetail entity) {

        NewsDetailDto newsDetailDto = new NewsDetailDto();
        newsDetailDto.setAddDate(entity.getAddDate());
        newsDetailDto.setFilterDto(filterMapper.toDto(entity.getFilter()));
        newsDetailDto.setEditDate(entity.getEditDate());
        newsDetailDto.setHeaderTitle(entity.getHeaderTitle());
        newsDetailDto.setId(entity.getId());
        newsDetailDto.setLang(entity.getLang());
        newsDetailDto.setText(entity.getText());
        newsDetailDto.setTitle(entity.getTitle());
        return newsDetailDto;
    }

    @Override
    public List<NewsDetail> toEntities(List<NewsDetailDto> dtoList) {

        return dtoList.stream().map(x->{
            NewsDetail newsDetail = new NewsDetail();
            newsDetail.setAddDate(x.getAddDate());
            newsDetail.setFilter(filterMapper.toEntity(x.getFilterDto()));
            newsDetail.setEditDate(x.getEditDate());
            newsDetail.setHeaderTitle(x.getHeaderTitle());
            newsDetail.setId(x.getId());
            newsDetail.setLang(x.getLang());
            newsDetail.setText(x.getText());
            newsDetail.setTitle(x.getTitle());
            return newsDetail;
        }).collect(Collectors.toList());
    }

    @Override
    public List<NewsDetailDto> toDtos(List<NewsDetail> entities) {

        return entities.stream().map(x->{
            NewsDetailDto newsDetailDto = new NewsDetailDto();
            newsDetailDto.setAddDate(x.getAddDate());
            newsDetailDto.setFilterDto(filterMapper.toDto(x.getFilter()));
            newsDetailDto.setEditDate(x.getEditDate());
            newsDetailDto.setHeaderTitle(x.getHeaderTitle());
            newsDetailDto.setId(x.getId());
            newsDetailDto.setLang(x.getLang());
            newsDetailDto.setText(x.getText());
            newsDetailDto.setTitle(x.getTitle());
            return newsDetailDto;
        }).collect(Collectors.toList());
    }
}
