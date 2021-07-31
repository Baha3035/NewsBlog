package kg.megacom.NewsBlog.services.impl;



import kg.megacom.NewsBlog.dao.NewsDetailRepo;
import kg.megacom.NewsBlog.mappers.NewsDetailMapper;
import kg.megacom.NewsBlog.models.dto.ImageDto;
import kg.megacom.NewsBlog.models.dto.NewsDetailDto;
import kg.megacom.NewsBlog.models.enums.Lang;
import kg.megacom.NewsBlog.models.outputNewsDetail.OutputImages;
import kg.megacom.NewsBlog.models.outputNewsDetail.OutputNewsDetail;
import kg.megacom.NewsBlog.services.FilterService;
import kg.megacom.NewsBlog.services.ImageService;
import kg.megacom.NewsBlog.services.NewsDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsDetailServiceImpl implements NewsDetailService {
    @Autowired
    private NewsDetailRepo newsDetailRepo;
    @Autowired
    private NewsDetailMapper newsDetailMapper;
    @Autowired
    private FilterService filterService;
    @Autowired
    private ImageService imageService;


    @Override
    public List<NewsDetailDto> findAll() {
        return newsDetailMapper.toDtos(newsDetailRepo.findAll());
    }

    @Override
    public List<NewsDetailDto> findByFilterId(Long id) {
        return newsDetailMapper.toDtos(newsDetailRepo.findByFilterId(id));
    }

    @Override
    public List<OutputNewsDetail> findByLangAndNameOfFilter(Lang lang, Long id) {
        List<NewsDetailDto> newsDetailDtoListFiltered = findByFilterId(id); //Получаем список каналов по фильтру
        List<NewsDetailDto> newsDetailDtoList = newsDetailDtoListFiltered.stream().filter(x -> x.getLang()==lang).collect(Collectors.toList());
        List<OutputNewsDetail> outputNewsDetailList = new ArrayList<>();
        for (NewsDetailDto n:
             newsDetailDtoList) {
            OutputNewsDetail outputNewsDetail = new OutputNewsDetail();
            List<OutputImages> outputImagesList1 = imageService.findByNewsDetailId(n.getId()).stream().map(z->{ //Заполняем OutputImagesList с помощью imageService.findByNewsDetailId()
                OutputImages outputImages = new OutputImages();
                outputImages.setUrl(z.getUrl());
                outputImages.setOrderNum(z.getOrderNum());
                return outputImages;
            }).collect(Collectors.toList());
            outputNewsDetail.setOutputImages(outputImagesList1); //Заполняем OutputNewsDetail
            outputNewsDetail.setLang(n.getLang());
            outputNewsDetail.setTitle(n.getTitle());
            outputNewsDetail.setText(n.getText());
            outputNewsDetail.setHeaderTitle(n.getHeaderTitle());
            outputNewsDetail.setAddDate(n.getAddDate());
            outputNewsDetail.setEditDate(n.getEditDate());
            outputNewsDetailList.add(outputNewsDetail);
        }
        return outputNewsDetailList;
    }

    @Override
    public List<OutputNewsDetail> findByLang(Lang lang) {
        List<NewsDetailDto> newsDetailDtoListFiltered = findAll(); //Получаем список каналов по фильтру
        List<NewsDetailDto> newsDetailDtoList = newsDetailDtoListFiltered.stream().filter(x -> x.getLang()==lang).collect(Collectors.toList());
        List<OutputNewsDetail> outputNewsDetailList = new ArrayList<>();

        for (NewsDetailDto n:
                newsDetailDtoList) {
            OutputNewsDetail outputNewsDetail = new OutputNewsDetail();
            List<OutputImages> outputImagesList1 = imageService.findByNewsDetailId(n.getId()).stream().map(z->{ //Заполняем OutputImagesList с помощью imageService.findByNewsDetailId()
                OutputImages outputImages = new OutputImages();
                outputImages.setUrl(z.getUrl());
                outputImages.setOrderNum(z.getOrderNum());
                return outputImages;
            }).collect(Collectors.toList());
            outputNewsDetail.setOutputImages(outputImagesList1); //Заполняем OutputNewsDetail
            outputNewsDetail.setLang(n.getLang());
            outputNewsDetail.setTitle(n.getTitle());
            outputNewsDetail.setText(n.getText());
            outputNewsDetail.setHeaderTitle(n.getHeaderTitle());
            outputNewsDetail.setAddDate(n.getAddDate());
            outputNewsDetail.setEditDate(n.getEditDate());
            outputNewsDetailList.add(outputNewsDetail);
        }
        return outputNewsDetailList;
    }

    @Override
    public List<OutputNewsDetail> findAllOutputs() {
        List<NewsDetailDto> newsDetailDtoList = findAll(); //Получаем список каналов по фильтру
        List<OutputNewsDetail> outputNewsDetailList = new ArrayList<>();

        for (NewsDetailDto n:
                newsDetailDtoList) {
            OutputNewsDetail outputNewsDetail = new OutputNewsDetail();
            List<OutputImages> outputImagesList1 = imageService.findByNewsDetailId(n.getId()).stream().map(z->{ //Заполняем OutputImagesList с помощью imageService.findByNewsDetailId()
                OutputImages outputImages = new OutputImages();
                outputImages.setUrl(z.getUrl());
                outputImages.setOrderNum(z.getOrderNum());
                return outputImages;
            }).collect(Collectors.toList());
            outputNewsDetail.setOutputImages(outputImagesList1); //Заполняем OutputNewsDetail
            outputNewsDetail.setLang(n.getLang());
            outputNewsDetail.setTitle(n.getTitle());
            outputNewsDetail.setText(n.getText());
            outputNewsDetail.setHeaderTitle(n.getHeaderTitle());
            outputNewsDetail.setAddDate(n.getAddDate());
            outputNewsDetail.setEditDate(n.getEditDate());
            outputNewsDetailList.add(outputNewsDetail);
        }
        return outputNewsDetailList;
    }

    @Override
    public NewsDetailDto save(NewsDetailDto newsDetailDto) {
        return newsDetailMapper.toDto(newsDetailRepo.save(newsDetailMapper.toEntity(newsDetailDto)));
    }

}
