// Hiyerarşi 2'nin Başı
public abstract class Mekan {
    private String blokAdi;
    private String katNo;

    public Mekan(String blokAdi, String katNo) {
        this.blokAdi = blokAdi;
        this.katNo = katNo;
    }

    public abstract void ozellikleriGoster();

    public String getKonumBilgisi() {
        return blokAdi + " Blok, " + katNo + ". Kat";
    }
}