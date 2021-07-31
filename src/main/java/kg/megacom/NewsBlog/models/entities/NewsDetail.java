package kg.megacom.NewsBlog.models.entities;

import lombok.Data;

import javax.persistence.*;

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
    @JoinColumn(name = "id_news")
    private News news;
    @ManyToOne
    @JoinColumn(name = "id_filters")
    private Filter filters;
}
