package kg.megacom.NewsBlog.models.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    @ManyToOne
    @JoinColumn(name = "id_news_details")
    private NewsDetail newsDetail;
    private int orderNum;
    private boolean active;
}
