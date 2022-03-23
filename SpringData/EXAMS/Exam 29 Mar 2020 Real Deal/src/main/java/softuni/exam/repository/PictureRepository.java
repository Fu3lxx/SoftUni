package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Picture;

import java.util.Set;

@Repository
public interface PictureRepository extends JpaRepository<Picture,Long> {

    Set<Picture> findAllByCar_Id (Long carId);

}
