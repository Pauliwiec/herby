package main.java.pauliwiec.herbaty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HerbatyRepository {

	private HashMap<Integer, Herbata> kolekcjaHerbat;
	private static int idCounter = 0;

	HerbatyRepository() {
		kolekcjaHerbat = new HashMap<Integer, Herbata>();
	}

	private int generateId() {
		idCounter++;
		return idCounter;
	}

	public Herbata find(int id) throws Exception {
		Herbata herba = kolekcjaHerbat.get(id);
		if (herba == null) {
			throw new Exception("Herbaty o takim id nie ma w repozytorium.");
		}
		return herba;
	}

	public void save(Herbata herba) {
		if (herba.getId() == 0) {
			herba.setId(generateId());
		}
		kolekcjaHerbat.put(herba.getId(), herba);
	}

	public List<Herbata> findAll() {
		return new ArrayList<Herbata>(kolekcjaHerbat.values());
	}
}
