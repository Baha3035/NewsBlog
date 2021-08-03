package kg.megacom.NewsBlog.models.entities;

import jdk.jfr.Timestamp;
import kg.megacom.NewsBlog.models.enums.Lang;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "news_details")
public class NewsDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String headerTitle;
    private String text;
    @ManyToOne
    @JoinColumn(name = "id_filters")
    private Filter filter;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date addDate;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date editDate;
    @Enumerated(EnumType.STRING)
    private Lang lang;
}
