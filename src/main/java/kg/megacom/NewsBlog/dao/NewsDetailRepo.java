package kg.megacom.NewsBlog.dao;

import kg.megacom.NewsBlog.models.entities.NewsDetail;
import kg.megacom.NewsBlog.models.enums.Lang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsDetailRepo extends JpaRepository<NewsDetail, Long> {
    List<NewsDetail> findByFilterId(Long id);

    List<NewsDetail> findByLang(Lang lang);
}
