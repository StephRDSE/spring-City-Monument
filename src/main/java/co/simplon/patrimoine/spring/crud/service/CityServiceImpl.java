package co.simplon.patrimoine.spring.crud.service;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import co.simplon.patrimoine.spring.crud.model.City;
import co.simplon.patrimoine.spring.crud.repository.CityRepo;

@Service
public class CityServiceImpl implements CityService {

	@Inject
	private CityRepo cityRepo;

	@Override
	public City saveCity(City city) {
		return cityRepo.save(city);
	}

	@Override
	public List<City> getAll() {
		return cityRepo.findAll();
	}

	@Override
	public List<City> getByName(String name) {
		return cityRepo.findByName(name);
	}

	@Override
	public Optional<City> findById(Long id) {
		return cityRepo.findById(id);
	}

	@Override
	public void removeById(Long id) {
		cityRepo.deleteById(id);

	}

}
