package kg.megacom.NewsBlog.controllers;

import kg.megacom.NewsBlog.models.dto.FilterDto;
import kg.megacom.NewsBlog.models.enums.Lang;
import kg.megacom.NewsBlog.services.FilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("api/v1/filters")
public class FilterController {
    @Autowired
    private FilterService filterService;
    @PostMapping("/save")
    FilterDto save(@RequestBody FilterDto filterDto){
        return filterService.save(filterDto);
    }

    @GetMapping("/all")
    List<FilterDto> findAll(){
        return filterService.findAll();
    }

    @GetMapping("/findByLang")
    List<FilterDto> findByLang(@RequestParam String lang){
        Lang lang1 = Lang.valueOf(lang.toUpperCase(Locale.ROOT));
        return filterService.findByLang(lang1);
    }
}
