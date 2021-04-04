import java.awt.*;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

public class Peaklass{
    // exception viivituse proovimiseks
    public static void main(String[] args) throws Exception{

        Küsimus nädalaPäev = new Küsimus("Mis päev on kaks päeva enne päeva, mis järgneb kohe päevale kolm päeva enne päeva, mis on kaks päeva pärast päeva kohe enne reedet?", new String[]{"pühapäev", "teisipäev", "neljapäev"}, 1, 10);
        Küsimus arvud = new Küsimus("Mu õde oli 10 aastat tagasi minust kaks korda vanem, nüüd on ta 26-aastane. Kui vana ma olen?",new String[]{"18-aastane", "16-aastane", "13-aastane"}, 0, 10);
        Küsimus kolmnurgad = new Küsimus("Mitu kolmnurka on pildil?", new String[]{"27","25", "17"}, 0, 10, "kolmnurgad.jpg");
        Küsimus ruudud = new Küsimus("Mitu ruutu on pildil?", new String[]{"10","11", "12"}, 1, 10, "ruudud.jpg");
        Küsimus misMaOlen = new Küsimus("Kui mind korrutatakse suvalise numbriga, on vastuses olevate numbrite summa alati mina ise. Mis ma olen?", new String[]{"1", "9", "2"}, 1, 10);
        Küsimus mitmesKoht = new Küsimus("Sa möödud jooksuvõistlusel teisel kohal jooksvast jooksjast. Mitmendal kohal sa oled?", new String[]{"Sõltub osalejate arvust", "1.", "2."}, 2, 10);
        Küsimus kuubik = new Küsimus("Milline kuubik vastab antud pinnalaotusele?", new String[]{"a","b","c","d"}, 3, 10, "kuubik.jpg");
        Küsimus blokid = new Küsimus("Mitmest kuubikust koosneb antud kujund?", new String[]{"a","b","c","d","e"},3,10, "blokid.jpg");
        Küsimus[] küsimused1 = new Küsimus[]{nädalaPäev, arvud, misMaOlen, mitmesKoht};
        Küsimus[] küsimused2 = new Küsimus[]{ruudud, kolmnurgad, kuubik, blokid};

        int punktid = 0;

        for (int i = 0; i < küsimused1.length; i++) {
            voor(i+1, punktid);
            TimeUnit.SECONDS.sleep(1);
            JList list = new JList(new String[] {küsimused1[i].getVastusevariandid()[0], küsimused1[i].getVastusevariandid()[1], küsimused1[i].getVastusevariandid()[2]});
            UIManager.put("OptionPane.minimumSize",new Dimension(800,100));
            JOptionPane.showMessageDialog(
                    null, list, küsimused1[i].getKüsimus(), JOptionPane.PLAIN_MESSAGE);
            punktid = õigeVastus(küsimused1[i], list.getSelectedIndex(),punktid);
        }
        System.out.println("Said esimesest plokist kokku " + punktid + " punkti!");
        System.out.println("Edasi tuleb pildiküsimuste plokk.");

        for (int i = 0; i < küsimused2.length; i++) {
            voor(i+1+küsimused1.length, punktid);
            TimeUnit.SECONDS.sleep(2);
            JFrame f=new JFrame();
            f.setPreferredSize(new Dimension(800, 800));
            f.pack();
            String proov = küsimused2[i].getFailinimi();
            f.add(new JLabel(new ImageIcon(proov)));
            f.setVisible(true);
            JList list = new JList(new String[]{küsimused2[i].getVastusevariandid()[0], küsimused2[i].getVastusevariandid()[1], küsimused2[i].getVastusevariandid()[2]});
            if (küsimused2[i].getVastusevariandid().length == 4) {
                list = new JList(new String[]{küsimused2[i].getVastusevariandid()[0], küsimused2[i].getVastusevariandid()[1], küsimused2[i].getVastusevariandid()[2], küsimused2[i].getVastusevariandid()[3]});
            }
            else if (küsimused2[i].getVastusevariandid().length == 5) {
                list = new JList(new String[]{küsimused2[i].getVastusevariandid()[0], küsimused2[i].getVastusevariandid()[1], küsimused2[i].getVastusevariandid()[2], küsimused2[i].getVastusevariandid()[3], küsimused2[i].getVastusevariandid()[4]});
            }
            UIManager.put("OptionPane.minimumSize",new Dimension(800,100));
            JOptionPane.showMessageDialog(
                    null, list, küsimused2[i].getKüsimus(), JOptionPane.PLAIN_MESSAGE);
            f.dispose();
            punktid = õigeVastus(küsimused2[i], list.getSelectedIndex(),punktid);
        }
        System.out.println("Said mälumängust kokku " + punktid + " punkti!");
    }//main


    public static void voor(int mitmes, int punktid){
        System.out.println("Käimas on " + mitmes + ". voor!");
        System.out.println("Punktiskoor: " + punktid + " punkti");
    }

    public static int õigeVastus(Küsimus küsimus, int vastus, int punktid){
        int võimalus = 1 + (int)(Math.random()*((7-1) + 1));
        if (küsimus.getVastus() == vastus){
            if (võimalus == 1) System.out.println("Tubli!");
            else if (võimalus == 2) System.out.println("Hea töö!");
            else if (võimalus == 3) System.out.println("LETS GO!!!");
            else if (võimalus == 4) System.out.println("Õige vastus!");
            else if (võimalus == 5) System.out.println("Vapustav!");
            else if (võimalus == 6) System.out.println("Õige!");
            else if (võimalus == 7) System.out.println("Õige vastus! Jätka samas vaimus!");
            punktid += küsimus.getPunktid();
        }
        else{
            if (võimalus == 1) System.out.println("Vale!");
            else if (võimalus == 2) System.out.println("Vale vastus!");
            else if (võimalus == 3) System.out.println("Ebaõnn!");
            else if (võimalus == 4) System.out.println("Kahjuks eksisid...");
            else if (võimalus == 5) System.out.println("Sinu vastus on vale!");
            else if (võimalus == 6) System.out.println("Vastasid valesti!");
            else if (võimalus == 7) System.out.println("Vastus ei olnud õige!");
            punktid -= küsimus.getPunktid();
        }
        return punktid;
    }


}
