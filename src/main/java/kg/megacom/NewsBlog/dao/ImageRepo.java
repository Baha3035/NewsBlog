package kg.megacom.NewsBlog.dao;

import kg.megacom.NewsBlog.models.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepo extends JpaRepository<Image, Long> {
}
