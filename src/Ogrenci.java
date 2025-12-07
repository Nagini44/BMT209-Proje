import java.time.LocalDate;

// Gereksinim 4.3: Hem kalıtım (extends) hem interface (implements)
public class Ogrenci extends Kisi implements IDegerlendirilebilir {

    // Gereksinim 2.1: Primitive ve Wrapper kullanımı
    private Double vizeNotu;
    private Double finalNotu;
    private int ogrenciNo;
    private boolean aktifMi;

    // Gereksinim 3: Constructor Overloading (2)
    public Ogrenci(long id, String ad, String soyad, LocalDate dogumTarihi, int ogrenciNo) {
        super(id, ad, soyad, dogumTarihi);
        this.ogrenciNo = ogrenciNo;
        this.aktifMi = true;
    }

    // Gereksinim 3: Setter içinde Exception ve Kontrol
    public void setVizeNotu(Double vizeNotu) throws HataliVeriException {
        if (vizeNotu == null) throw new HataliVeriException("Not null olamaz!");
        if (vizeNotu < 0 || vizeNotu > 100) {
            throw new HataliVeriException("Vize notu 0-100 arasında olmalıdır.");
        }
        this.vizeNotu = vizeNotu;
    }

    public void setFinalNotu(Double finalNotu) throws HataliVeriException {
        if (finalNotu < 0 || finalNotu > 100) {
            throw new HataliVeriException("Final notu 0-100 arasında olmalıdır.");
        }
        this.finalNotu = finalNotu;
    }

    // Gereksinim 4.4: Polymorphism (Override)
    @Override
    public void bilgileriGoster() {
        System.out.println("Öğrenci: " + getAd() + " " + getSoyad() + " (No: " + ogrenciNo + ")");
    }

    @Override
    public String getRolAdi() {
        return Unvan.OGRENCI.toString();
    }

    // Interface Metotları Implementation
    @Override
    public double notOrtalamasiHesapla() {
        // Gereksinim 2.2: Aritmetik operatörler
        if (vizeNotu == null || finalNotu == null) return 0.0;
        return (vizeNotu * 0.4) + (finalNotu * 0.6);
    }

    @Override
    public String harfNotuGetir() {
        double ort = notOrtalamasiHesapla();
        // Gereksinim 9: Koşul yapıları (if-else zinciri)
        if (ort >= 90) return "AA";
        else if (ort >= 80) return "BA";
        else if (ort >= 70) return "BB";
        else if (ort >= 50) return "CC";
        else return "FF";
    }

    @Override
    public boolean gectiMi() {
        // Gereksinim 2.2: Karşılaştırma operatörleri
        return notOrtalamasiHesapla() >= 50;
    }

    // Getterlar
    public Double getVizeNotu() { return vizeNotu; }
    public Double getFinalNotu() { return finalNotu; }
    public int getOgrenciNo() { return ogrenciNo; }
}