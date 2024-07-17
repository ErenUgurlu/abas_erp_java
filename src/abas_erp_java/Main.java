package abas_erp_java;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		
		Servis servis = new Servis();

		List<Mal> malListesi1 = new ArrayList<Mal>();
		List<Mal> malListesi2 = new ArrayList<Mal>();
		List<Mal> malListesi3 = new ArrayList<Mal>();

		malListesi1.add(new Mal(2000, 100.51, 12));
		malListesi1.add(new Mal(2001, 200, 31));
		malListesi1.add(new Mal(2002, 150.86, 22));
		malListesi1.add(new Mal(2003, 250, 41));
		malListesi1.add(new Mal(2004, 244, 55));

		malListesi2.add(new Mal(2001, 44.531, 88));
		malListesi2.add(new Mal(2002, 88.11, 121));
		malListesi2.add(new Mal(2004, 211, 74));
		malListesi2.add(new Mal(2002, 88.11, 14));

		malListesi3.add(new Mal(2003, 12.1, 2));
		malListesi3.add(new Mal(2004, 22.3, 3));
		malListesi3.add(new Mal(2003, 12.1, 8));
		malListesi3.add(new Mal(2002, 94, 16));
		malListesi3.add(new Mal(2005, 44.1, 9));
		malListesi3.add(new Mal(2006, 90, 19));

		List<Siparis> siparisListesi = new ArrayList<Siparis>();

		siparisListesi.add(new Siparis(1000, malListesi1, 0));
		siparisListesi.add(new Siparis(1001, malListesi2, 0));
		siparisListesi.add(new Siparis(1002, malListesi3, 0));
		System.out.println("3 Siparişteki malların ooplam tutarı: " + servis.toplamFiyat(siparisListesi));
		System.out.println("3 Siparişteki bütün mallarınortalama fiyatı: " + servis.ortalamaFiyat(siparisListesi));
		System.out.println("3 siparişteki bütün malların tek tek mal bazlı ortalama fiyatı: " +servis.malBazliOrtalamaFiyat(siparisListesi));
		System.out.println("Tek tek mal bazlı, malların hangi siparişlerde kaç adet olduğu: "
				+"2000: "+servis.malMiktarıAra(siparisListesi,2000)
				+" | 2001: "+servis.malMiktarıAra(siparisListesi,2001)
				+" | 2002: "+servis.malMiktarıAra(siparisListesi,2002)
				+" | 2003: "+servis.malMiktarıAra(siparisListesi,2003)
				+" | 2004: "+servis.malMiktarıAra(siparisListesi,2004)
				+" | 2005: "+servis.malMiktarıAra(siparisListesi,2005)
				+" | 2006: "+servis.malMiktarıAra(siparisListesi,2006));
		
		//Weather API
        String getResponse = servis.sendGetRequest();
        System.out.println("GET Response: " + getResponse);
        
        
        String postResponse = servis.sendPostRequest();
        System.out.println("POST Response: " + postResponse);

	}

}
