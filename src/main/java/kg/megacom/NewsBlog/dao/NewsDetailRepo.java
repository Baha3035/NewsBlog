package kg.megacom.NewsBlog.dao;

import kg.megacom.NewsBlog.models.entities.NewsDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsDetailRepo extends JpaRepository<NewsDetail, Long> {
}
