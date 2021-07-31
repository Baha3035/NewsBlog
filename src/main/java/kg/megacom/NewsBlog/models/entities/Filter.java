package kg.megacom.NewsBlog.models.entities;

import kg.megacom.NewsBlog.models.enums.Lang;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "filters")
public class Filter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Lang lang;
    private boolean active;
}
