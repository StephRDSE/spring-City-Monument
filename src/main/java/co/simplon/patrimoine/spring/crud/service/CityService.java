package co.simplon.patrimoine.spring.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import co.simplon.patrimoine.spring.crud.model.City;

@Service
public interface CityService {

	public City saveCity(City city);

	public List<City> getAll();

	public List<City> getByName(String name);

	public Optional<City> findById(Long id);

	public void removeById(Long id);

}
