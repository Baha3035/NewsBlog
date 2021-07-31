package kg.megacom.NewsBlog.models.dto;

import kg.megacom.NewsBlog.models.entities.NewsDetail;
import lombok.Data;

import javax.persistence.*;

@Data
public class ImageDto {
    private Long id;
    private String url;
    private NewsDetailDto newsDetailDto;
    private int orderNum;
    private boolean active;
}
