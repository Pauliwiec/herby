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
//		List<Herbata> listaHerbat = new ArrayList<Herbata>();
//		Herbata zielonaJasminowa = new Herbata("jasminowa", RodzajHerbaty.ZIELONA);
//		zielonaJasminowa.setId(1);
//		Herbata czarnaTropikalna = new Herbata("owocowa", RodzajHerbaty.CZARNA);
//		czarnaTropikalna.setId(2);
//		Herbata zielonaCytrynowa = new Herbata("cytrynowa", RodzajHerbaty.ZIELONA);
//		zielonaCytrynowa.setId(3);
//		Herbata biala = new Herbata("klasyczna", RodzajHerbaty.BIALA);
//		biala.setId(4);
//		
//		listaHerbat.add(zielonaCytrynowa);
//		listaHerbat.add(czarnaTropikalna);
//		listaHerbat.add(biala);
//		listaHerbat.add(zielonaJasminowa);
		
		return herbatyRepository.findAll();
	}
	
	@RequestMapping(value = "/herbata/{id}", method=RequestMethod.GET)
	public Herbata getHerbata(@PathVariable("id") int id){
//		Herbata herbata = new Herbata("imbirowa", RodzajHerbaty.CZARNA);
//		herbata.setId(id);
//		return herbata;
		
		try {
			return herbatyRepository.find(id);
		} catch (Exception e) {
			return new Herbata();
		}
	}
	
	@RequestMapping(value="/herbata", method=RequestMethod.POST)
	public Herbata addHerbata(@RequestBody Herbata herbata) {
		//int id = 1 + (int)(Math.random() * 100);
		//herbata.setId(id);
		herbatyRepository.save(herbata);
		
		return herbata;
	}
}
