package kg.megacom.NewsBlog.models.entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "short_desk")
    private String shortDesk;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date addDate;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date editDate;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
}
