package kg.megacom.NewsBlog.controllers;

import kg.megacom.NewsBlog.models.dto.ImageDto;
import kg.megacom.NewsBlog.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class ImageController {
    @Autowired
    ImageService imageService;

    @GetMapping("FindById")
    List<ImageDto> findById(@PathVariable Long id){
        return imageService.findIdByNewsDetailId(id);
    }

}
