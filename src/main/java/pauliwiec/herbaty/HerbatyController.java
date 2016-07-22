package main.java.pauliwiec.herbaty;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HerbatyController {
	
	private HerbatyRepository herbatyRepository;
	
	HerbatyController(){
		herbatyRepository = new HerbatyRepository();
	}

	@RequestMapping(value="/herbata", method=RequestMethod.GET)
	public List<Herbata> getHerbaty(){
	    
	    //every GET request adds objects to repository, so to do: cleanRepository() method
	    herbatyRepository.save(new Herbata("jasminowa", RodzajHerbaty.ZIELONA));
	    herbatyRepository.save(new Herbata("owocowa", RodzajHerbaty.CZARNA));
	    herbatyRepository.save(new Herbata("cytrynowa", RodzajHerbaty.ZIELONA));
	    
	    //for localhost, with /herbata url GEt returns jsona (default format in Spring)
		return herbatyRepository.findAll();
	}
	
	@RequestMapping(value = "/herbata/{id}", method=RequestMethod.GET)
	public Herbata getHerbata(@PathVariable("id") int id){
		
		try {
			return herbatyRepository.find(id); //ex. http://localhost:8080/herbata/2 returns herbata with id=2
		} catch (Exception e) {
			return new Herbata(); //if no object found, returns empty object (not a perfect solution;))
		}
	}
	
	@RequestMapping(value="/herbata", method=RequestMethod.POST)
	public Herbata addHerbata(@RequestBody Herbata herbata) {

		herbatyRepository.save(herbata);
		
		return herbata;
	}
}
