package kg.megacom.NewsBlog.services.impl;


import kg.megacom.NewsBlog.dao.NewsDetailRepo;
import kg.megacom.NewsBlog.exceptions.NewsNotFoundException;
import kg.megacom.NewsBlog.mappers.NewsDetailMapper;
import kg.megacom.NewsBlog.models.dto.FilterDto;
import kg.megacom.NewsBlog.models.dto.ImageDto;
import kg.megacom.NewsBlog.models.dto.NewsDetailDto;
import kg.megacom.NewsBlog.models.enums.Lang;
import kg.megacom.NewsBlog.models.inputNewsDetails.InputImageDto;
import kg.megacom.NewsBlog.models.inputNewsDetails.InputNewsDetail;
import kg.megacom.NewsBlog.models.outputNewsDetail.OutputImages;
import kg.megacom.NewsBlog.models.outputNewsDetail.OutputNewsDetail;
import kg.megacom.NewsBlog.services.FilterService;
import kg.megacom.NewsBlog.services.ImageService;
import kg.megacom.NewsBlog.services.NewsDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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
                outputImages.setId(z.getId());
                return outputImages;
            }).collect(Collectors.toList());
            outputNewsDetail.setOutputImages(outputImagesList1); //Заполняем OutputNewsDetail
            outputNewsDetail.setLang(n.getLang());
            outputNewsDetail.setTitle(n.getTitle());
            outputNewsDetail.setText(n.getText());
            outputNewsDetail.setHeaderTitle(n.getHeaderTitle());
            outputNewsDetail.setAddDate(n.getAddDate());
            outputNewsDetail.setEditDate(n.getEditDate());
            outputNewsDetail.setNewsDetailId(n.getId());
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
                outputImages.setId(z.getId());
                return outputImages;
            }).collect(Collectors.toList());
            outputNewsDetail.setOutputImages(outputImagesList1); //Заполняем OutputNewsDetail
            outputNewsDetail.setLang(n.getLang());
            outputNewsDetail.setTitle(n.getTitle());
            outputNewsDetail.setText(n.getText());
            outputNewsDetail.setHeaderTitle(n.getHeaderTitle());
            outputNewsDetail.setAddDate(n.getAddDate());
            outputNewsDetail.setEditDate(n.getEditDate());
            outputNewsDetail.setNewsDetailId(n.getId());
            outputNewsDetailList.add(outputNewsDetail);
        }
        return outputNewsDetailList;
    }

    @Override
    public List<OutputNewsDetail> findAllOutputs() {
        List<NewsDetailDto> newsDetailDtoList = findAll();
        List<OutputNewsDetail> outputNewsDetailList = new ArrayList<>();

        for (NewsDetailDto n:
                newsDetailDtoList) {
            OutputNewsDetail outputNewsDetail = new OutputNewsDetail();
            List<OutputImages> outputImagesList1 = imageService.findByNewsDetailId(n.getId()).stream().map(z->{ //Заполняем OutputImagesList с помощью imageService.findByNewsDetailId()
                OutputImages outputImages = new OutputImages();
                outputImages.setUrl(z.getUrl());
                outputImages.setOrderNum(z.getOrderNum());
                outputImages.setId(z.getId());
                return outputImages;
            }).collect(Collectors.toList());
            outputNewsDetail.setOutputImages(outputImagesList1); //Заполняем OutputNewsDetail
            outputNewsDetail.setLang(n.getLang());
            outputNewsDetail.setTitle(n.getTitle());
            outputNewsDetail.setText(n.getText());
            outputNewsDetail.setHeaderTitle(n.getHeaderTitle());
            outputNewsDetail.setAddDate(n.getAddDate());
            outputNewsDetail.setEditDate(n.getEditDate());
            outputNewsDetail.setNewsDetailId(n.getId());
            outputNewsDetailList.add(outputNewsDetail);
        }
        return outputNewsDetailList;
    }

    @Override
    public OutputNewsDetail updateOutputNews(Long id, InputNewsDetail inputNewsDetail) {
        NewsDetailDto newsDetailDto = newsDetailMapper.toDto(newsDetailRepo.findById(id).orElseThrow(()->new NewsNotFoundException("News not found!")));
        newsDetailDto.setFilterDto(filterService.findById(inputNewsDetail.getFilterId()));
        newsDetailDto.setHeaderTitle(inputNewsDetail.getHeaderTitle());
        newsDetailDto.setTitle(inputNewsDetail.getTitle());
        newsDetailDto.setText(inputNewsDetail.getText());
        Lang lang1 = Lang.valueOf(inputNewsDetail.getLang().toUpperCase(Locale.ROOT));
        newsDetailDto.setLang(lang1);
        NewsDetailDto savedNewsDetailDto = newsDetailMapper.toDto(newsDetailRepo.save(newsDetailMapper.toEntity(newsDetailDto)));
        List<OutputImages> outputImagesList = new ArrayList<>();
        List<InputImageDto> inputImageDtoList = inputNewsDetail.getInputImageDtos();

        List<ImageDto> imageDtosUpdated = inputImageDtoList.stream().map(x->{
            if(x.getImageId() == null){
                return imageService.saveInputImageDto(x, inputNewsDetail.getNewsDetailId());
            }
            InputImageDto inputImageDto = new InputImageDto();
            inputImageDto.setImageId(x.getImageId());
            inputImageDto.setUrl(x.getUrl());
            inputImageDto.setOrderNum(x.getOrderNum());
            return imageService.update(x.getImageId(), inputImageDto);
        }).collect(Collectors.toList());

        outputImagesList = imageDtosUpdated.stream().map(y->{
            OutputImages outputImages = new OutputImages();
            outputImages.setId(y.getId());
            outputImages.setUrl(y.getUrl());
            outputImages.setOrderNum(y.getOrderNum());
            return outputImages;
        }).collect(Collectors.toList());

        OutputNewsDetail outputNewsDetail = new OutputNewsDetail();
        outputNewsDetail.setOutputImages(outputImagesList);
        outputNewsDetail.setNewsDetailId(id);
        outputNewsDetail.setText(savedNewsDetailDto.getText());
        outputNewsDetail.setHeaderTitle(savedNewsDetailDto.getHeaderTitle());
        outputNewsDetail.setTitle(savedNewsDetailDto.getTitle());
        outputNewsDetail.setAddDate(savedNewsDetailDto.getAddDate());
        outputNewsDetail.setEditDate(savedNewsDetailDto.getEditDate());
        outputNewsDetail.setLang(savedNewsDetailDto.getLang());
        return outputNewsDetail;
    }

    @Override
    public NewsDetailDto findById(Long id) {
        return newsDetailMapper.toDto(newsDetailRepo.findById(id).orElseThrow(() -> new NewsNotFoundException("News not found!!!")));
    }

    @Override
    public NewsDetailDto updateLang(Lang lang1, Long newsId) {
        NewsDetailDto newsDetailDto = findById(newsId);
        newsDetailDto.setLang(lang1);
        return newsDetailMapper.toDto(newsDetailRepo.save(newsDetailMapper.toEntity(newsDetailDto)));
    }

    @Override
    public NewsDetailDto save(NewsDetailDto newsDetailDto) {
        FilterDto filterDto = filterService.findById(newsDetailDto.getFilterDto().getId());
        newsDetailDto.setFilterDto(filterDto);
        return newsDetailMapper.toDto(newsDetailRepo.save(newsDetailMapper.toEntity(newsDetailDto)));
    }
}
