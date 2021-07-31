package kg.megacom.NewsBlog.services;

import kg.megacom.NewsBlog.models.dto.NewsDetailDto;
import kg.megacom.NewsBlog.models.entities.NewsDetail;
import kg.megacom.NewsBlog.models.enums.Lang;
import kg.megacom.NewsBlog.models.outputNewsDetail.OutputNewsDetail;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface NewsDetailService {
    List<NewsDetailDto> findAll();

    List<NewsDetailDto> findByFilterId(Long id);

    List<OutputNewsDetail> findByLangAndNameOfFilter(Lang lang, Long id);

    NewsDetailDto save(NewsDetailDto newsDetailDto);

    List<OutputNewsDetail> findByLang(Lang lang);

    List<OutputNewsDetail> findAllOutputs();
}