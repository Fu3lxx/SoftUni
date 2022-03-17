package com.example.advquerying.repositories;

import com.example.advquerying.entities.Label;
import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo,Long> {

    List<Shampoo> findAllBySizeOrderById (Size size);
    List<Shampoo> findAllBySizeOrLabelIdOrderByPrice(Size size, Long labelId);
    List<Shampoo> findAllByPriceGreaterThanOrderByPriceDesc(BigDecimal price);
    int countAllByPriceIsLessThan(BigDecimal price);

    @Query("select s from Shampoo s JOIN s.ingredients i where i.name in :names")
    List<Shampoo> findAllByIngredientsNames(List<String> names);

    @Query("select s from Shampoo s join s.ingredients i group by s.id having count (i) < :ingCount")
    List<Shampoo> findAllByShampooIngredientsCountLessThan(Long ingCount);



}
