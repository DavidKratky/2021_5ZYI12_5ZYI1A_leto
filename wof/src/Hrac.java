import java.util.ArrayList;

/**
 * 28. 2. 2021 - 21:14
 *
 * @author janik
 */
public class Hrac {
    private Miestnost aktualnaMiestnost;
    private final ArrayList<String> inventar;

    public Hrac(Miestnost aktualnaMiestnost) {
        this.aktualnaMiestnost = aktualnaMiestnost;
        this.inventar = new ArrayList<>();
    }

    public Miestnost getAktualnaMiestnost() {
        return this.aktualnaMiestnost;
    }

    void posunSa(String smer) {
        Miestnost novaMiestnost = this.aktualnaMiestnost.getMiestnostVSmere(smer);

        if (novaMiestnost == null) {
            System.out.println("Tam nie je vychod!");
        } else {
            this.aktualnaMiestnost = novaMiestnost;
            this.getAktualnaMiestnost().vypisMiestnost();
        }
    }

    public void zdvihniPredmet(String nazovPredmetu) {
        if (this.aktualnaMiestnost.odstranPredmet(nazovPredmetu)) {
            this.inventar.add(nazovPredmetu);
        } else {
            System.out.println("Taky predmet nevidis");
        }
    }

    public void odhodPredmet(String nazovPredmetu) {
        if (this.inventar.remove(nazovPredmetu)) {
            this.aktualnaMiestnost.vlozPredmet(nazovPredmetu);
        } else {
            System.out.println("Taky predmet nemas");
        }
    }
}
