package kg.megacom.NewsBlog.services.impl;

import kg.megacom.NewsBlog.dao.FilterRepo;
import kg.megacom.NewsBlog.exceptions.FilterNotFoundException;
import kg.megacom.NewsBlog.mappers.FilterMapper;
import kg.megacom.NewsBlog.models.dto.FilterDto;
import kg.megacom.NewsBlog.models.enums.Lang;
import kg.megacom.NewsBlog.services.FilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilterServiceImpl implements FilterService {
    @Autowired
    private FilterRepo filterRepo;

    @Autowired
    private FilterMapper filterMapper;

    @Override
    public FilterDto findByLangAndId(Lang lang, Long id) {
        return filterMapper.toDto(filterRepo.findByLangAndId(lang, id));
    }

    @Override
    public FilterDto findById(Long id) {
        return filterMapper.toDto(filterRepo.findById(id).orElseThrow(() -> new FilterNotFoundException("Filter not found!!!")));
    }

    @Override
    public FilterDto save(FilterDto filterDto) {
        return filterMapper.toDto(filterRepo.save(filterMapper.toEntity(filterDto)));
    }

    @Override
    public List<FilterDto> findAll() {
        return filterMapper.toDtos(filterRepo.findAll());
    }

    @Override
    public FilterDto findByLangAndName(Lang lang, String name) {
        return filterMapper.toDto(filterRepo.findByLangAndName(lang, name));
    }

    @Override
    public List<FilterDto> findByLang(Lang lang) {
        return filterMapper.toDtos(filterRepo.findByLang(lang));
    }
}
