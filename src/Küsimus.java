import java.util.List;

public class Küsimus {
    private String küsimus;
    private int vastus;
    private String[] vastusevariandid;
    private int punktid;
    private String failinimi;

    public Küsimus(String küsimus, String[] vastusevariandid, int vastus, int punktid) {
        this.küsimus = küsimus;
        this.vastus = vastus;
        this.vastusevariandid = vastusevariandid;
        this.punktid = punktid;
    }

    public Küsimus(String küsimus, String[] vastusevariandid, int vastus, int punktid, String failinimi) {
        this.küsimus = küsimus;
        this.vastus = vastus;
        this.vastusevariandid = vastusevariandid;
        this.punktid = punktid;
        this.failinimi = failinimi;
    }

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
