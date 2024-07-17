package abas_erp_java;

import java.util.List;

public class Siparis {

	private int siparisNo;
	private List<Mal> malListesi;
	
	

	public Siparis() {
		
	}
	public Siparis(int siparisNo, List<Mal> malListesi, int miktar) {
		super();
		this.siparisNo = siparisNo;
		this.malListesi = malListesi;
		
	}

	public int getSiparisNo() {
		return siparisNo;
	}
	public void setSiparisNo(int siparisNo) {
		this.siparisNo = siparisNo;
	}
	public List<Mal> getMalListesi() {
		return malListesi;
	}

	public void setMalListesi(List<Mal> malListesi) {
		this.malListesi = malListesi;
	}

	
}
