package softuni.exam.instagraphlite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.exam.instagraphlite.models.entity.Picture;

import java.util.List;

public interface PictureRepository extends JpaRepository<Picture,Long> {

    Picture findByPath(String path);

    List<Picture> findBySizeIsGreaterThanOrderBySizeAsc(double size);
}
