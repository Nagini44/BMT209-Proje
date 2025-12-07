public class Laboratuvar extends Mekan {
    private int bilgisayarSayisi;
    private String labAdi;

    public Laboratuvar(String blok, String kat, String labAdi, int pcSayisi) {
        super(blok, kat);
        this.labAdi = labAdi;
        this.bilgisayarSayisi = pcSayisi;
    }

    @Override
    public void ozellikleriGoster() {
        System.out.println("LABORATUVAR [" + labAdi + "] - " + getKonumBilgisi());
        System.out.println("   PC Sayısı: " + bilgisayarSayisi);
    }
}