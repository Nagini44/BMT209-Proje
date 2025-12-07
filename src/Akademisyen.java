import java.time.LocalDate;

public abstract class Akademisyen extends Kisi {
    private String sicilNo;
    private double maas;

    public Akademisyen(long id, String ad, String soyad, LocalDate dt, String sicilNo) {
        super(id, ad, soyad, dt);
        this.sicilNo = sicilNo;
    }

    // Abstract metodu override edip somutlaştırmadık, bu sınıf hala abstract.
    // Ancak yeni abstract metot ekleyebiliriz.
    public abstract double maasHesapla();

    public String getSicilNo() { return sicilNo; }
    public void setMaas(double maas) { this.maas = maas; }
    public double getMaas() { return maas; }
}
