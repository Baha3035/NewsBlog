package kg.megacom.NewsBlog.models.outputNewsDetail;

import kg.megacom.NewsBlog.models.enums.Lang;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OutputNewsDetail {
    private String title;
    private String headerTitle;
    private String text;
    private Date addDate;
    private Date editDate;
    private Lang lang;
    private List<OutputImages> outputImages;
    private Long newsDetailId;
}
