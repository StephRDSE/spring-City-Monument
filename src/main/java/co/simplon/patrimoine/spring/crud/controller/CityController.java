package co.simplon.patrimoine.spring.crud.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import co.simplon.patrimoine.spring.crud.model.City;
import co.simplon.patrimoine.spring.crud.service.CityService;

@Controller
@RequestMapping("/city")
public class CityController {

	@Inject
	private CityService cityService;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public String create(@ModelAttribute City city) {
		cityService.saveCity(city);
		return "La ville : " + city.getName() + " a bien été enregistrée sous l'ID " + city.getId() + ".";
	}

	@RequestMapping(method = RequestMethod.GET)
	// pour lui dire de construire automatiquement la reponse
	@ResponseBody
	public List<City> find(@RequestParam(name = "nameCity", defaultValue = "") String name) {
		System.out.println("nameCity=[" + name + "]");
		List<City> liste = new ArrayList<>();
		if (!name.equals("")) {
			liste = cityService.getByName(name);
		} else {
			liste = cityService.getAll();
		}
		return liste;
	}

	@RequestMapping(value = "/{idDansURL}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public City findById(@PathVariable("idDansURL") Long id) {
		City citySearched = null;
		Optional<City> cityFinded = cityService.findById(id);
		if (cityFinded.isPresent()) {
			citySearched = cityFinded.get();
		}
		return citySearched;
	}

	@RequestMapping(method = RequestMethod.PATCH)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public String update(@ModelAttribute City city) {
		cityService.saveCity(city);
		return "";
	}

	@RequestMapping(method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public String delete(@ModelAttribute Long id) {
		City cityToDelete = null;
		Optional<City> city = cityService.findById(id);
		if (city.isPresent()) {
			cityToDelete = city.get();
		}
		cityService.removeById(id);
		return "La ville : " + cityToDelete.getName() + " ayant pour ID " + id + "a bien été supprimée.";
	}

}
