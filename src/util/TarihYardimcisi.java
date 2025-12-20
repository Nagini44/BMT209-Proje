package util;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * Tarih ve zaman işlemleri için yardımcı sınıf.
 * GEREKSİNİM 1.1: En az 2 adet yardımcı / utility sınıfı.
 */
public class TarihYardimcisi {

    // GEREKSİNİM 6: DateTimeFormatter kullanımı
    private static final DateTimeFormatter GORUNUM_FORMATI = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     * Doğum tarihine göre yaş hesaplar.
     * GEREKSİNİM 6: Tarih üzerinde hesaplama (Period).
     */
    public static int yasHesapla(LocalDate dogumTarihi) {
        if (dogumTarihi == null) return 0;
        return Period.between(dogumTarihi, LocalDate.now()).getYears();
    }

    /**
     * Tarihi "Gün/Ay/Yıl" formatında stringe çevirir.
     * GEREKSİNİM 6: Formatlama.
     */
    public static String tarihFormatla(LocalDate tarih) {
        if (tarih == null) return "Tarih Yok";
        return tarih.format(GORUNUM_FORMATI);
    }

    /**
     * İki tarih arasındaki gün farkını kontrol eder (Örn: Sınav süresi kontrolü).
     * GEREKSİNİM 6: Karşılaştırma (isBefore, isAfter).
     */
    public static boolean tarihGecmisMi(LocalDate tarih) {
        return tarih.isBefore(LocalDate.now());
    }
}