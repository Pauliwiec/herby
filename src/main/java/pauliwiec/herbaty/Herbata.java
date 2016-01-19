package main.java.pauliwiec.herbaty;

public class Herbata {

	private RodzajHerbaty rodzaj;
	private String smak;
	private int id; 

	public RodzajHerbaty getRodzaj() {
		return rodzaj;
	}

	public void setRodzaj(RodzajHerbaty rodzaj) {
		this.rodzaj = rodzaj;
	}

	public String getSmak() {
		return smak;
	}

	public void setSmak(String smak) {
		this.smak = smak;
	}

	Herbata() {
	}

	Herbata(String smak, RodzajHerbaty rodzaj) {
		this.smak = smak;
		this.rodzaj = rodzaj;
	}

	Herbata(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
