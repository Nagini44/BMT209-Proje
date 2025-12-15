import java.time.LocalDate;

public class Akademisyen extends Kisi { // 1. Değişiklik: 'abstract' kelimesi silindi
    private String sicilNo;
    private double maas;

    public Akademisyen(long id, String ad, String soyad, LocalDate dt, String sicilNo) {
        super(id, ad, soyad, dt);
        this.sicilNo = sicilNo;
    }

    // 2. Değişiklik: Abstract metot artık somutlaştırıldı (içeriği yazıldı).
    // Artık bu sınıftan nesne üretildiğinde bu metot çalıştırılabilir.
    public double maasHesapla() {
        // Varsayılan olarak mevcut maaşı döndürebiliriz veya
        // buraya temel bir hesaplama mantığı yazabiliriz.
        return this.maas;
    }
    @Override
    public void bilgileriGoster() {
        // Kisi sınıfındaki alanlara erişiminiz varsa (getAd(), getSoyad() vb.) buraya ekleyebilirsiniz.
        // Örnek bir çıktı:
        System.out.println("--- Akademisyen Bilgileri ---");
        System.out.println("Sicil No: " + this.sicilNo);
        System.out.println("Maaş: " + this.maas);
    }

    @Override
    public String getRolAdi() {return "Akademisyen";}


    public String getSicilNo() { return sicilNo; }
    public void setMaas(double maas) { this.maas = maas; }
    public double getMaas() { return maas; }
}