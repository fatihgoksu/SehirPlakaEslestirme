package SehirPlakaEslestirme;

public class Sehir {

	private String name;
	private int plaka;

	public Sehir() {
	}

	public Sehir(String name, int plaka) {
		this.name = name;
		this.plaka = plaka;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPlat() {
		return plaka;
	}

	public void setPlat(int plaka) {
		this.plaka = plaka;
	}

	@Override
	public String toString() {
		return "   " + name + " = " + plaka + "   ";
	}
}
