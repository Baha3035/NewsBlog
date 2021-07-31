package kg.megacom.NewsBlog.models.dto;

import kg.megacom.NewsBlog.models.enums.Lang;
import lombok.Data;

import javax.persistence.*;

@Data
public class FilterDto {
    private Long id;
    private String name;
    private Lang lang;
    private boolean active;
}
