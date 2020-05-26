import java.io.Serializable;

public class Peryferia implements Serializable {

    private String myszka;
    private String sluchawki;
    private String klawiatura;

    public Peryferia(String myszka, String sluchawki, String klawiatura) {
        this.myszka = myszka;
        this.sluchawki = sluchawki;
        this.klawiatura = klawiatura;
    }

    @Override
    public String toString() {
        return myszka + sluchawki + klawiatura;
    }
}
