package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Offer;
import softuni.exam.models.enums.ApartmentType;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer,Long> {


    @Query ("SELECT o from Offer o where o.apartment.apartmentType = :apartmentType order by o.apartment.area desc ,o.price")
    List<Offer> findAllByApartmentTypeOrdered (@Param("apartmentType") ApartmentType apartmentType);

}
