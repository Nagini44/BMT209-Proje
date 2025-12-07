import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Gereksinim 1.1: Yardımcı (Utility) Sınıf
public class JsonIslemleri {

    // Gereksinim 10: Static metot ve alan
    private static final String DOSYA_YOLU = "ogrenciler.json";

    // Gereksinim 8: I/O İşlemleri (BufferedWriter)
    // Bu metot basit bir JSON formatında string oluşturup dosyaya yazar.
    public static void ogrencileriKaydet(List<Ogrenci> ogrenciler) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DOSYA_YOLU))) {
            writer.write("[\n");
            for (int i = 0; i < ogrenciler.size(); i++) {
                Ogrenci o = ogrenciler.get(i);
                // Gereksinim 2.2: String işlemleri (replace, format vb.)
                String jsonNesne = String.format(
                        "  {\"id\":%d, \"ad\":\"%s\", \"soyad\":\"%s\", \"no\":%d}",
                        o.getId(), o.getAd(), o.getSoyad(), o.getOgrenciNo()
                );

                writer.write(jsonNesne);
                if (i < ogrenciler.size() - 1) {
                    writer.write(",\n");
                }
            }
            writer.write("\n]");
            System.out.println("Veriler JSON formatında kaydedildi: " + DOSYA_YOLU);
        } catch (IOException e) {
            // Gereksinim 7: Exception yönetimi
            System.err.println("Dosya yazma hatası: " + e.getMessage());
        }
    }

    // Gereksinim 8: Dosyadan Okuma (BufferedReader)
    // Basit string parsing ile JSON okumayı simüle ediyoruz.
    public static List<Ogrenci> ogrencileriYukle() {
        List<Ogrenci> liste = new ArrayList<>();
        File file = new File(DOSYA_YOLU);

        if (!file.exists()) return liste;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                // Gereksinim 2.2: String metotları (contains, split, replace)
                if (line.startsWith("{") && line.contains("id")) {
                    line = line.replace("{", "").replace("}", "").replace("\"", "");
                    String[] parcalar = line.split(",");

                    long id = 0;
                    String ad = "", soyad = "";
                    int no = 0;

                    // Parse işlemi (Manuel JSON parse)
                    for (String parca : parcalar) {
                        String[] kv = parca.split(":");
                        String key = kv[0].trim();
                        String val = kv[1].trim();

                        // Gereksinim 9: Switch-case
                        switch (key) {
                            case "id": id = Long.parseLong(val); break;
                            case "ad": ad = val; break;
                            case "soyad": soyad = val; break;
                            case "no": no = Integer.parseInt(val); break;
                        }
                    }
                    // Nesne oluşturma
                    liste.add(new Ogrenci(id, ad, soyad, LocalDate.now(), no));
                }
            }
        } catch (Exception e) {
            System.err.println("Dosya okuma hatası: " + e.getMessage());
        }
        return liste;
    }
}