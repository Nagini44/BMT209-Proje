public class Ofis extends Mekan {
    private String akademisyenAdi;

    public Ofis(String blok, String kat, String akademisyenAdi) {
        super(blok, kat);
        this.akademisyenAdi = akademisyenAdi;
    }

    @Override
    public void ozellikleriGoster() {
        System.out.println("AKADEMİSYEN OFİSİ - " + getKonumBilgisi());
        System.out.println("   Sahibi: " + akademisyenAdi);
    }
}