import java.time.LocalDate;

public class Akademisyen extends Kisi {
    private String sicilNo;
    private double maas;

    public Akademisyen(long id, String ad, String soyad, LocalDate dt, String sicilNo) {
        super(id, ad, soyad, dt);
        this.sicilNo = sicilNo;
    }

    // 1. Zorunluluk: Akademisyen'in kendi abstract metodu (önceki adımdan)

    public double maasHesapla() {
        return this.maas;
    }

    // 2. Zorunluluk: Kisi sınıfından gelen abstract metot (Hata veren kısım burasıydı)
    @Override
    public void bilgileriGoster() {
        // Kisi sınıfındaki alanlara erişiminiz varsa (getAd(), getSoyad() vb.) buraya ekleyebilirsiniz.
        // Örnek bir çıktı:
        System.out.println("--- Akademisyen Bilgileri ---");
        System.out.println("Sicil No: " + this.sicilNo);
        System.out.println("Maaş: " + this.maas);
    }

    @Override
    public String getRolAdi() {
        return "Akademisyen";
    }

    public String getSicilNo() { return sicilNo; }
    public void setMaas(double maas) { this.maas = maas; }
    public double getMaas() { return maas; }
}