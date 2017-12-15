package SehirPlakaEslestirme;

import java.util.List;

public class Cevap {

	private List<Sehir> cityList;
	private int trueResult;

	public Cevap() {
	}

	public Cevap(List<Sehir> cityList, int trueResult) {
		this.cityList = cityList;
		setTrueResult(trueResult);
	}

	public void setCityList(List<Sehir> cityList) {
		this.cityList = cityList;
	}

	public void setTrueResult(int trueResult) {
		this.trueResult = trueResult;
	}

	@Override
	public String toString() {
		// return cityList + ", trueResult=" + getTrueResult();
		return cityList + "";
	}

	public int getTrueResult() {
		return trueResult;
	}
}
