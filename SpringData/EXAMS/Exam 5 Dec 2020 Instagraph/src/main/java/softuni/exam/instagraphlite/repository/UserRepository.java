package softuni.exam.instagraphlite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import softuni.exam.instagraphlite.models.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);

    @Query("select distinct u from User u order by size(u.posts) desc, u.id")
    List<User> findAllUsersOrderedByCountOfPictures();
}
