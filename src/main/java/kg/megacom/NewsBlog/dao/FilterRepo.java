package kg.megacom.NewsBlog.dao;

import kg.megacom.NewsBlog.models.entities.Filter;
import kg.megacom.NewsBlog.models.enums.Lang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilterRepo extends JpaRepository<Filter, Long> {
    Filter findByLangAndId(Lang lang, Long id);

    Filter findByLangAndName(Lang lang, String name);

    List<Filter> findByLang(Lang lang);
}
