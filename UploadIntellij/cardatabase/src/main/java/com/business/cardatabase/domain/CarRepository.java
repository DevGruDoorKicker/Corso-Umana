package com.business.cardatabase.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
//@RepositoryRestResource(path="vehicles") //cambio nome nell'url
public interface CarRepository extends CrudRepository<Car, Long> {

    List<Car> findByBrand(String brand);
   /* List<Car> findByColor(String color);
    List<Car> findByYr(int yr);
    List<Car> findByBrandOrColor(String brand, String color);
    List<Car> findByBrandOrderByYrAsc(String brand);
    @Query("select c from Car c where c.brand like %?1")        // JPAQL
    List<Car> findByBrandEndsWith(String brand);

    */
}
