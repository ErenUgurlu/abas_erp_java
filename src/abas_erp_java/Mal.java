package abas_erp_java;

public class Mal {
	private int malNo;
	private double fiyat;
	private int miktar;
	
	public Mal(int malNo, double fiyat,int miktar) {
		this.malNo = malNo;
		this.fiyat = fiyat;
		this.miktar = miktar;
	}
	public Mal() {

	}
	public double getFiyat() {
		return fiyat;
	}
	public void setFiyat(double fiyat) {
		this.fiyat = fiyat;
	}
	public int getMalNo() {
		return malNo;
	}
	public void setMalNo(int malNo) {
		this.malNo = malNo;
	}
	public int getMiktar() {
		return miktar;
	}
	public void setMiktar(int miktar) {
		this.miktar = miktar;
	}
	

	
}
