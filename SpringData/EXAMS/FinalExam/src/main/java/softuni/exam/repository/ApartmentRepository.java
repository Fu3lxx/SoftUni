package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Apartment;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment,Long> {

    Apartment findByTown_TownNameAndArea (String name, BigDecimal area);

    Optional<Apartment> findById(Long id);



}
