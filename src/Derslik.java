public class Derslik extends Mekan {
    private String derslikKodu; // Örn: D-101
    private int kontenjan;

    public Derslik(String blok, String kat, String kod, int kontenjan) {
        super(blok, kat);
        this.derslikKodu = kod;
        this.kontenjan = kontenjan;
    }

    @Override
    public void ozellikleriGoster() {
        System.out.println("DERSLİK [" + derslikKodu + "] - Konum: " + getKonumBilgisi());
        System.out.println("   Kontenjan: " + kontenjan);
    }

    public String getDerslikKodu() { return derslikKodu; }
}