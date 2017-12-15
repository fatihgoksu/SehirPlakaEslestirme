package SehirPlakaEslestirme;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static final int RANGE = 80;
	public static int sayi = 0;
	public static int tur = 0;
	public static int dogru = 0;

	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		BufferedReader in = new BufferedReader(new FileReader("kod.txt"));
		String str;

		List<String> list = new ArrayList<String>();
		List cityList = new ArrayList();
		while ((str = in.readLine()) != null) {
			cityList.add(str);
		}

		List<Sehir> sehirList = new ArrayList();

		for (int i = 0; i < cityList.size(); i++) {
			String line = (String) cityList.get(i);
			String plat = line.split("\\s+")[0];
			String name = line.split("\\s+")[1];
			int plaka = Integer.parseInt(plat);

			Sehir sehir = new Sehir(name, plaka);
			sehirList.add(sehir);

		}

		do {
			Random random = new Random();
			int trueIndex = random.nextInt(80);
			Sehir sehirTrue = sehirList.get(trueIndex);
			int falseIndex = uniqueRandomIndex(trueIndex);
			Sehir sehirFalse = new Sehir();
			sehirFalse.setName(sehirList.get(falseIndex).getName());
			sehirFalse.setPlat(sehirList.get(uniqueRandomIndex(falseIndex)).getPlat());
			List<Sehir> currentList = new ArrayList<Sehir>();
			Cevap question = new Cevap();

			int resultIndex = random.nextInt(2);
			if (resultIndex == 0) {
				currentList.add(sehirTrue);
				currentList.add(sehirFalse);
				question.setTrueResult(1);
			} else {
				currentList.add(sehirFalse);
				currentList.add(sehirTrue);
				question.setTrueResult(2);
			}
			System.out.print("Plaka Þehir Eþleþtirme Oyunu Hoþgeldiniz!	  			");
			System.out.print("Doðru: " + dogru);
			System.out.println("  Tur: " + tur);
			tur++;
			System.out.println(
					"-------------------------------------------------------------------------------------------");
			System.out.println("Oyundan çýkmak için (0) giriniz.");
			System.out.println("");

			question.setCityList(currentList);
			System.out.println(question);
			System.out.println("");
			System.out.println(
					"Sizce Hangi eþleþme doðrudur?(Birinci Secenek Ýçin '1',Ýkinci Secenek Ýçin '2' Tuþlayýnýz)");

			sayi = input.nextInt();

			if (sayi == 0) {
				System.out.println("Plaka Þehir Eþleþtirme Oyunu Ýstatistikler:");
				System.out.println("Toplam Tur Sayýsý :" + tur);
				System.out.println("Toplam doðru eþleþtirme sayýsý :" + dogru);
				System.out.println("Güle Güle...");
				System.exit(0); // Programdan çýktýn.
			} else {
				if (sayi == question.getTrueResult()) {
					// System.out.print("Helal Doðruyu Buldun:");
					dogru++;
					// System.out.println(dogru);
				} else {
					// System.out.println("Yanlýþ");
				}
			}

		} while (tur < 30 || tur == 0);

	}

	private static int uniqueRandomIndex(int index) {
		Random random = new Random();
		int uniqueIndex = random.nextInt(5);
		if (uniqueIndex == index) {
			do {
				uniqueIndex = random.nextInt(5);
			} while (uniqueIndex == index);
		}

		return uniqueIndex;
	}
}
