public class SisestusegaKüsimus {
    private String küsimus;
    private String vastus;
    private int punktid;

    public SisestusegaKüsimus(String küsimus, String vastus, int punktid) {
        this.küsimus = küsimus;
        this.vastus = vastus;
        this.punktid = punktid;
    }

    public String getKüsimus() {
        return küsimus;
    }

    public String getVastus() {
        return vastus;
    }

    public int getPunktid() {
        return punktid;
    }
}
