import java.util.List;

public class Küsimus {
    private String küsimus;
    private String vastus;
    private List<String> vastusevariandid;

    public Küsimus(String küsimus, List<String> vastusevariandid, String vastus) {
        this.küsimus = küsimus;
        this.vastus = vastus;
        this.vastusevariandid = vastusevariandid;
    }

    public String getKüsimus() {
        return küsimus;
    }

    public String getVastus() {
        return vastus;
    }
}
