import java.util.List;

public class Küsimus {
    private String küsimus;
    private int vastus;//Int-tüüpi, sest annab indeksi, mitmes vastusevariantidest õige on
    private String[] vastusevariandid;
    private int punktid;//Kui palju punkte küsimus väärt on
    private String failinimi;//Pildiga küsimuste jaoks

    public Küsimus(String küsimus, String[] vastusevariandid, int vastus, int punktid) {//Konstruktor
        this.küsimus = küsimus;
        this.vastus = vastus;
        this.vastusevariandid = vastusevariandid;
        this.punktid = punktid;
    }

    public Küsimus(String küsimus, String[] vastusevariandid, int vastus, int punktid, String failinimi) {//Teine konstruktor piltidega küsimuste jaoks (sest sisaldab failinime)
        this.küsimus = küsimus;
        this.vastus = vastus;
        this.vastusevariandid = vastusevariandid;
        this.punktid = punktid;
        this.failinimi = failinimi;
    }

    //Kõikvõimalikud get-meetodid
    public String getKüsimus() {
        return küsimus;
    }

    public int getVastus() {
        return vastus;
    }

    public int getPunktid() {
        return punktid;
    }

    public String[] getVastusevariandid() {
        return vastusevariandid;
    }

    public String getFailinimi() {
        return failinimi;
    }
}
