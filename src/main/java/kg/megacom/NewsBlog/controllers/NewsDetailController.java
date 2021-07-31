package kg.megacom.NewsBlog.controllers;

import kg.megacom.NewsBlog.models.dto.NewsDetailDto;
import kg.megacom.NewsBlog.services.NewsDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/news")
public class NewsDetailController {

    @Autowired
    private NewsDetailService newsDetailService;

    @GetMapping("/allNews")
    public List<NewsDetailDto> findAll(){
     return  newsDetailService.findAll();
    }
}
