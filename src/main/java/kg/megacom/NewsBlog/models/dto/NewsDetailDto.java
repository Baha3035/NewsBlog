package kg.megacom.NewsBlog.models.dto;

import kg.megacom.NewsBlog.models.entities.Filter;
import kg.megacom.NewsBlog.models.enums.Lang;
import lombok.Data;

import java.util.Date;

@Data
public class NewsDetailDto {
    private Long id;
    private String title;
    private String headerTitle;
    private String text;
    private FilterDto filterDto;
    private Date addDate;
    private Date editDate;
    private Lang lang;
}
