package kg.megacom.NewsBlog.models.dto;

import lombok.Data;

@Data
public class ImageDto {
    private Long id;
    private String url;
    private NewsDetailDto newsDetailDto;
    private int orderNum;
    private boolean active;
}
