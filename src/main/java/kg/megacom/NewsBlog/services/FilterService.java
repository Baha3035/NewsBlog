package kg.megacom.NewsBlog.services;

import kg.megacom.NewsBlog.models.dto.FilterDto;
import kg.megacom.NewsBlog.models.entities.Filter;
import kg.megacom.NewsBlog.models.enums.Lang;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface FilterService {
    FilterDto findByLangAndId(Lang lang, Long id);

    FilterDto findById(Long id);

    FilterDto save(FilterDto filterDto);

    List<FilterDto> findAll();
    FilterDto findByLangAndName(Lang lang, String name);

    List<FilterDto> findByLang(Lang lang);
}
