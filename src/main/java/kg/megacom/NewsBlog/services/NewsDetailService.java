package kg.megacom.NewsBlog.services;

import kg.megacom.NewsBlog.models.dto.NewsDetailDto;
import kg.megacom.NewsBlog.models.enums.Lang;
import kg.megacom.NewsBlog.models.inputNewsDetails.InputNewsDetail;
import kg.megacom.NewsBlog.models.outputNewsDetail.OutputNewsDetail;

import java.util.List;

public interface NewsDetailService {
    List<NewsDetailDto> findAll();

    List<NewsDetailDto> findByFilterId(Long id);

    List<OutputNewsDetail> findByLangAndNameOfFilter(Lang lang, Long id);

    NewsDetailDto save(NewsDetailDto newsDetailDto);

    List<OutputNewsDetail> findByLang(Lang lang);

    List<OutputNewsDetail> findAllOutputs();

    OutputNewsDetail updateOutputNews(Long id, InputNewsDetail inputNewsDetail);

    NewsDetailDto findById(Long Id);

    NewsDetailDto updateLang(Lang lang1, Long newsId);
}