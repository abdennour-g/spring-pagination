package org.ma.springpagination.repository;

import org.ma.springpagination.entitie.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestResource
@CrossOrigin("*")
public interface CityRepository extends JpaRepository<City,Long> {
}
