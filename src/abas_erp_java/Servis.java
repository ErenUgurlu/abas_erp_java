package abas_erp_java;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Servis {
	/**
	 * Üç siparişteki malların toplam tutarının çıktısını veren java kodu.
	 * @param siparisListesi
	 * @return
	 */
	public double toplamFiyat(List<Siparis> siparisListesi) {

		double toplam = 0;
		for (Siparis s : siparisListesi) {
			for (Mal mal : s.getMalListesi()) {
				toplam = toplam +(mal.getFiyat() * mal.getMiktar());
				
			}
		}
		return toplam;
	}
	/**
	 * Üç siparişteki bütün malların ortalama fiyatını bulan java kodu.
	 * @param siparisListesi
	 * @return
	 */
	public double ortalamaFiyat(List<Siparis> siparisListesi) {

		long malAdeti = 0;
		for (Siparis s : siparisListesi) {
			for (Mal m : s.getMalListesi()) {
				malAdeti += m.getMiktar();
				
			}

		}
		return toplamFiyat(siparisListesi) / malAdeti;
	}
	/**
	 * Üç siparişteki bütün malların tek tek mal bazlı ortalama fiyatını bulan java kodu.
	 * @param siparisListesi
	 * @return
	 */
	public Map<Integer, Double> malBazliOrtalamaFiyat(List<Siparis> siparisListesi) {
		List<Mal> malListesi = new ArrayList<Mal>();

		for (Siparis s : siparisListesi) {
			malListesi.addAll(s.getMalListesi());
		}
        Map<Integer, Double> toplamFiyatlar = new HashMap<>();
        Map<Integer, Integer> malSayilari = new HashMap<>();
        for (Mal mal : malListesi) {
            int malNumarasi = mal.getMalNo();
            double birimFiyat = mal.getFiyat();

            toplamFiyatlar.put(malNumarasi, toplamFiyatlar.getOrDefault(malNumarasi, 0.0) + birimFiyat);
            malSayilari.put(malNumarasi, malSayilari.getOrDefault(malNumarasi, 0) + 1);
        }

        Map<Integer, Double> ortalamaFiyatlar = new HashMap<>();
        for (Map.Entry<Integer, Double> entry : toplamFiyatlar.entrySet()) {
            int malNumarasi = entry.getKey();
            double toplamFiyat = entry.getValue();
            int sayi = malSayilari.get(malNumarasi);
            double ortalamaFiyat = toplamFiyat / sayi;
            ortalamaFiyatlar.put(malNumarasi, ortalamaFiyat);
        }

        return ortalamaFiyatlar;
	}
	/**
	 * Tek tek mal bazlı, malların hangi siparişlerde kaç adet olduğunun çıktısını veren
	 * java kodu.
	 * @param siparisListesi
	 * @param malNo
	 * @return
	 */
	public Map<Integer, Integer> malMiktarıAra(List<Siparis> siparisListesi, Integer malNo) {
	    return siparisListesi.stream()
	        .flatMap(siparis -> siparis.getMalListesi().stream() // Use getMalListesi()
	            .filter(urun -> urun.getMalNo() == malNo) // Filter by the Mal object directly
	            .map(urun -> new AbstractMap.SimpleEntry<>(siparis.getSiparisNo(), urun.getMiktar()))
	        )
	        .collect(Collectors.groupingBy(
	            Map.Entry::getKey, 
	            Collectors.summingInt(Map.Entry::getValue)
	        ));
	}
	
	 public String sendGetRequest(String city, String apiKey) {
	        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;
	        HttpClient client = HttpClient.newHttpClient();
	        HttpRequest request = HttpRequest.newBuilder()
	                .uri(URI.create(url))
	                .build();

	        try {
	            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
	            return "Response Code: " + response.statusCode() + "\nResponse Body: " + response.body();
	        } catch (IOException | InterruptedException e) {
	            e.printStackTrace();
	            return "Error: " + e.getMessage();
	        }
	    }

	    public String sendPostRequest(String city, String apiKey) {
	    	HttpRequest request = HttpRequest.newBuilder()
	    			.uri(URI.create("https://google-translate1.p.rapidapi.com/language/translate/v2/detect"))
	    			.header("x-rapidapi-key", "3d9aa34e38mshc3fb140d8eddbd8p11b7a1jsnb32f263e84af")
	    			.header("x-rapidapi-host", "google-translate1.p.rapidapi.com")
	    			.header("Content-Type", "multipart/form-data; boundary=---011000010111000001101001")
	    			.header("Accept-Encoding", "application/gzip")
	    			.method("POST", HttpRequest.BodyPublishers.ofString("-----011000010111000001101001\r\nContent-Disposition: form-data; name=\"q\"\r\n\r\nEnglish is hard, but detectably so\r\n-----011000010111000001101001--\r\n\r\n"))
	    			.build();
	        try {
	        	HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
	            return "Response Code: " + response.statusCode() + "\nResponse Body: " + response.body();
	        } catch (IOException | InterruptedException e) {
	            e.printStackTrace();
	            return "Error: " + e.getMessage();
	        }
	    }
}
