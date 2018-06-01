package co.simplon.patrimoine.spring.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.simplon.patrimoine.spring.crud.model.City;

@Repository
public interface CityRepo extends JpaRepository<City, Long> {

	public List<City> findByName(@Param("nameToFind") String name);

}
