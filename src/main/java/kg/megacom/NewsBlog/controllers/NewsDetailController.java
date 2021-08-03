package kg.megacom.NewsBlog.controllers;

import kg.megacom.NewsBlog.models.dto.NewsDetailDto;
import kg.megacom.NewsBlog.models.enums.Lang;
import kg.megacom.NewsBlog.models.inputNewsDetails.InputNewsDetail;
import kg.megacom.NewsBlog.models.outputNewsDetail.OutputNewsDetail;
import kg.megacom.NewsBlog.services.NewsDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("api/v1/news")
public class NewsDetailController {

    @Autowired
    private NewsDetailService newsDetailService;

    @GetMapping("/allNews")
    public List<NewsDetailDto> findAll(){

        return newsDetailService.findAll();
    }


    @GetMapping("/news-by-langAndName")
    public List<OutputNewsDetail> findAllByFilterId(@RequestParam String lang, @RequestParam Long id){
        Lang lang1 = Lang.valueOf(lang.toUpperCase(Locale.ROOT));
        return newsDetailService.findByLangAndNameOfFilter(lang1, id);
    }

    @GetMapping("/all-output-news-by-lang")
    public List<OutputNewsDetail> findAllNewsByLang(@RequestParam String lang){
        Lang lang1 = Lang.valueOf(lang.toUpperCase(Locale.ROOT));
        return newsDetailService.findByLang(lang1);
    }

    @PostMapping("/save")
    public NewsDetailDto save(@RequestBody NewsDetailDto newsDetailDto){
        return newsDetailService.save(newsDetailDto);
    }

    @GetMapping("/all-output-news")
    public List<OutputNewsDetail> allOutputNews(){
        return newsDetailService.findAllOutputs();
    }

    @PatchMapping("/update-news")
    public OutputNewsDetail update(@RequestParam Long id, @RequestBody InputNewsDetail inputNewsDetail){
        return newsDetailService.updateOutputNews(id, inputNewsDetail);
    }

    @PatchMapping("/update-lang")
    public NewsDetailDto updateLang(@RequestParam String lang, @RequestParam Long newsId){
        Lang lang1 = Lang.valueOf(lang.toUpperCase(Locale.ROOT));
        return newsDetailService.updateLang(lang1, newsId);
    }
}
