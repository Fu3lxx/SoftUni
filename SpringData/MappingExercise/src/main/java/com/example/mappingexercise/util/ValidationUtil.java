package com.example.mappingexercise.util;

import javax.validation.ConstraintViolation;
import java.util.Set;

public interface ValidationUtil {

   <E> Set<ConstraintViolation<E>> getViolations(E entity);
   <E> boolean isValid (E entity);
}
