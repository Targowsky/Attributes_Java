import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Komputer implements Serializable {

    private String numerSeryjny;
    private AdditionalGPU dodatkoweGpu; /* złożony */
    private Peryferia dodatki; /* opcjonalny */
    //private static int maxCena= 10000;
    //private static int minCena= 2000;
    private int cena;
    //atrybut klasowy
    private static int kosztDostawy= 20;
    //atrybut powtarzalny,
    /*atrybut powtarzalny to nazwa zestawu dla innych regionów sprzedaży (Azja),
      atrybutem biznesowym byłyby również TAGI dla komputera: #Gaming, #Business, #MovieMaking #School #fun #cheap*/
    private List<String> nazwyDlaRegionow;

    public Komputer(String numerSeryjny, AdditionalGPU dodatkoweGpu, Peryferia dodatki, int cena, List<String> nazwyDlaRegionow) {

        if (dodatkoweGpu== null) throw new NullPointerException("brak informacji o dodatkowym gpu");
        this.numerSeryjny = numerSeryjny;
        this.dodatkoweGpu = dodatkoweGpu;
        this.dodatki = dodatki;
        this.cena = cena;

        this.nazwyDlaRegionow = nazwyDlaRegionow;
        extent.add(this);
    }
    //przeciążenie (brak parametru Peryferia dodatki)
    public Komputer(String numerSeryjny, AdditionalGPU dodatkoweGpu, int cena, List<String> nazwyDlaRegionow) {

        if (dodatkoweGpu== null) throw new NullPointerException("brak informacji o dodatkowym gpu");
        this.numerSeryjny = numerSeryjny;
        this.dodatkoweGpu = dodatkoweGpu;
        this.cena = cena;
        this.nazwyDlaRegionow = nazwyDlaRegionow;
        extent.add(this);
    }

    //extensja
    private static List<Komputer> extent = new ArrayList<>();

    //atrybut (a raczej metoda get) pochodny/wyliczalny
    private int getKosztZdostawą(){
        return cena+kosztDostawy;
    }
    public void setCena(int newCena) {
        this.cena = cena+newCena;
    }


    //pokaż extensje klasy Komputer
    public static void showExtent() {
        System.out.println("Extent of the class: " + Komputer.class.getName());
        for (Komputer komputer : extent) {
            System.out.println(komputer);
        }
    }

    public static List<Komputer> wybierzZestawTanszyNiz(int cenaMaksymalna) {
        List<Komputer> listaKomputerow = new ArrayList<>();
        // jesli cena obiektu (każdego z ekstensji) spełnia warunek <= cenaMaksymalna to dodaj do listyKomputerów i zwroc.
        for (Komputer k : extent){
            if (k.cena <= cenaMaksymalna){
                listaKomputerow.add(k);
            }
        }return listaKomputerow;
        }


        /*public static void wyswietlNajdrozszy(){
        for (Komputer komputer : extent){
            if (komputer.cena == MostExpensivePC()){
                System.out.println(komputer);
            }
        }
        }*/

    //przykładowo nowy podatek albo np. niekorzystne warunki koniunkturalne powodujące wzrost ceny zestawu.
    public static void zwiekszCeneZestawu(int podniesCeneO) {
        for(Komputer k : extent) {
            k.setCena(podniesCeneO);
        }
    }


    //przesłonięcie, w klasie bazowej występuje już dokładnie ta sama metoda jednak nadpisuje ją wedle uznania(parametry bez zmian)
    @Override
    public String toString() {
        String extraPeryferia = dodatki == null ? " brak info. o dodatkach " : dodatki.toString(); //atrybut opcjonal
        return "Nr seryjny twojego gotowca to " + numerSeryjny + " dodatkowe Gpu to "+ dodatkoweGpu +
                " extra peryferia to " + extraPeryferia + " cena zestawu to " + cena
                + " a cena z dostawą " + getKosztZdostawą() + " nazwy dla regionów Azjatyckich " +nazwyDlaRegionow;
    }

    //otwieram stream wrzucam do niego całą extensje
    public static void writeExtent(ObjectOutputStream stream) throws IOException {
        stream.writeObject(extent);
    }
    //zaciągam wszystkie obiekty listy obiektów komputer do extensji
    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        extent = (List<Komputer>) stream.readObject();
    }
}

