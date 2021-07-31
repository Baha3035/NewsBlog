package kg.megacom.NewsBlog.controllers;


import kg.megacom.NewsBlog.mappers.ImageMapper;
import kg.megacom.NewsBlog.models.dto.ImageDto;
import kg.megacom.NewsBlog.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/images")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @Autowired
    private ImageMapper imageMapper;
    @PostMapping("/save")
    ImageDto save(@RequestBody ImageDto imageDto){
        return imageService.save(imageDto);
    }

    @GetMapping("/findAll")
    List<ImageDto> findAll(){
        return imageService.findAll();
    }
}
