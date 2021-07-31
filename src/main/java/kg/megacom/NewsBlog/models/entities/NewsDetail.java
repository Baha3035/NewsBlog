package kg.megacom.NewsBlog.models.entities;

import kg.megacom.NewsBlog.models.enums.Lang;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "news_details")
public class NewsDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String headerTitle;
    private String text;
    @ManyToOne
    @JoinColumn(name = "id_filters")
    private Filter filter;
    private Date addDate;
    private Date editDate;
    @Enumerated(EnumType.STRING)
    private Lang lang;
}
