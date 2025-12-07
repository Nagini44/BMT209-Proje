import java.util.*;

    // Gereksinim 5.1: Generic Sınıf
    public class VeriDeposu<T extends Kisi> {

        // Gereksinim 5.2: Collections (List, Map kullanımı)
        private List<T> liste;
        private Map<Long, T> idMap;

        public VeriDeposu() {
            this.liste = new ArrayList<>();
            this.idMap = new HashMap<>();
        }

        // Generic Metot: Ekleme
        public void ekle(T nesne) {
            liste.add(nesne);
            idMap.put(nesne.getId(), nesne);
        }

        // Silme
        public void sil(long id) {
            if (idMap.containsKey(id)) {
                T nesne = idMap.get(id);
                liste.remove(nesne);
                idMap.remove(id);
            }
        }

        // Generic Wildcard Kullanımı: List<? extends Number> Örneği
        // (Bonus bir özellik olarak yaş ortalaması gibi bir şey hesaplanabilir)
        public void yaslariYazdir(List<? extends Number> yaslar) {
            for(Number n : yaslar) {
                System.out.println("Yaş: " + n);
            }
        }

        // Arama
        public T bul(long id) {
            return idMap.get(id);
        }

        public List<T> getListe() {
            return liste;
        }

        // Gereksinim 5.2: Sıralama
        public void ismeGoreSirala() {
            // Lambda kullanımı (Bonus)
            Collections.sort(liste, (k1, k2) -> k1.getAd().compareTo(k2.getAd()));
        }
    }