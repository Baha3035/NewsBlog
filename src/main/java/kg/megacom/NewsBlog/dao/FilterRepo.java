package kg.megacom.NewsBlog.dao;

import kg.megacom.NewsBlog.models.entities.Filter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilterRepo extends JpaRepository<Filter, Long> {
}
