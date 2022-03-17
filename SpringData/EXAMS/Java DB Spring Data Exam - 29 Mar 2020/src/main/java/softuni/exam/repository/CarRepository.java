package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Car;
import softuni.exam.models.entity.Picture;

import java.util.List;
import java.util.Set;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {

    @Query ("SELECT c from Car c order by size(c.pictures) desc, c.make ")
    List<Car> findAllCarsSortByPictureCountAndMake();

}
