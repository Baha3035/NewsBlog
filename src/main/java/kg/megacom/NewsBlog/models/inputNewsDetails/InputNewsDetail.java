package kg.megacom.NewsBlog.models.inputNewsDetails;

import kg.megacom.NewsBlog.models.dto.FilterDto;
import kg.megacom.NewsBlog.models.dto.ImageDto;
import kg.megacom.NewsBlog.models.enums.Lang;
import kg.megacom.NewsBlog.models.outputNewsDetail.OutputImages;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class InputNewsDetail {
    private String title;
    private String headerTitle;
    private String text;
    private Date addDate;
    private Date editDate;
    private Lang lang;
    private FilterDto filterDto;
    private List<InputImageDto> inputImageDtos;
}
