package kg.megacom.NewsBlog.models.inputNewsDetails;

import lombok.Data;

import java.util.List;

@Data
public class InputNewsDetail {
    private String title;
    private String headerTitle;
    private String text;
    private String lang;
    private Long filterId;
    private List<InputImageDto> inputImageDtos;
    private Long newsDetailId;
}
