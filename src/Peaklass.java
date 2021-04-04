import java.awt.*;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

public class Peaklass{
    // exception viivituse proovimiseks
    public static void main(String[] args) throws InterruptedException {
        Küsimus rebane = new Küsimus("Mis on pildil?", new String[]{"Rebane", "Lehm", "Ilves"}, 0, 10);
        // ei tulnud midagi tarka hetkel
        Küsimus nädalaPäev = new Küsimus("Mis päev on kaks päeva enne päeva, mis järgneb kohe päevale kolm päeva enne päeva, mis on kaks päeva pärast päeva kohe enne reedet?", new String[]{"pühapäev", "teisipäev", "neljapäev"}, 1, 10);
        Küsimus arvud = new Küsimus("Mu õde oli 10 aastat tagasi minust kaks korda vanem, nüüd on ta 26-aastane. Kui vana ma olen?",new String[]{"18-aastane", "16-aastane", "13-aastane"}, 0, 10);
        Küsimus kolmnurgad = new Küsimus("Mitu kolmnurka on pildil?", new String[]{"27","25", "17"}, 0, 10, "kolmnurgad.jpg");
        Küsimus ruudud = new Küsimus("Mitu ruutu on pildil?", new String[]{"10","11", "12"}, 2, 10, "ruudud.jpg");
        SisestusegaKüsimus proov1 = new SisestusegaKüsimus("Mis päev täna on?", "pühapäev", 10);
        Küsimus[] küsimused1 = new Küsimus[]{nädalaPäev, arvud};
        Küsimus[] küsimused2 = new Küsimus[]{ruudud, kolmnurgad};

        int punktid = 0;

        for (int i = 0; i < 2; i++) {
            voor(i+1, punktid);
            TimeUnit.SECONDS.sleep(1);
            JList list = new JList(new String[] {küsimused1[i].getVastusevariandid()[0], küsimused1[i].getVastusevariandid()[1], küsimused1[i].getVastusevariandid()[2]});
            UIManager.put("OptionPane.minimumSize",new Dimension(1000,100));
            JOptionPane.showMessageDialog(
                    null, list, küsimused1[i].getKüsimus(), JOptionPane.PLAIN_MESSAGE);
            punktid = õigeVastus(küsimused1[i], list.getSelectedIndex(),punktid);
        }
        System.out.println("Said esimesest plokist kokku " + punktid + " punkti!");
        System.out.println("Edasi tuleb pildiküsimuste plokk.");

        for (int i = 0; i < 2; i++) {
            voor(i+1+2, punktid);
            TimeUnit.SECONDS.sleep(1);
            JFrame f=new JFrame();
            f.setPreferredSize(new Dimension(700, 700));
            f.pack();
            String proov = küsimused2[i].getFailinimi();
            f.add(new JLabel(new ImageIcon(proov)));
            f.setVisible(true);
            JList list = new JList(new String[] {küsimused2[i].getVastusevariandid()[0], küsimused2[i].getVastusevariandid()[1], küsimused2[i].getVastusevariandid()[2]});
            UIManager.put("OptionPane.minimumSize",new Dimension(1000,100));
            JOptionPane.showMessageDialog(
                    null, list, küsimused2[i].getKüsimus(), JOptionPane.PLAIN_MESSAGE);
            f.dispose();
            punktid = õigeVastus(küsimused2[i], list.getSelectedIndex(),punktid);
        }

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

    // meetod sisestusega küsimuse kontrollimiseks ja tagasiside andmiseks
    public static int SisestuseKontroll (SisestusegaKüsimus sisestusegaküsimus, String vastus, int punktid){
        int võimalus = 1 + (int)(Math.random()*((7-1) + 1));
        if (sisestusegaküsimus.getVastus().equals("pühapäev")) {
            if (võimalus == 1) System.out.println("Tubli!");
            else if (võimalus == 2) System.out.println("Hea töö!");
            else if (võimalus == 3) System.out.println("LETS GO!!!");
            else if (võimalus == 4) System.out.println("Õige vastus!");
            else if (võimalus == 5) System.out.println("Vapustav!");
            else if (võimalus == 6) System.out.println("Õige!");
            else if (võimalus == 7) System.out.println("Õige vastus! Jätka samas vaimus!");
            punktid += sisestusegaküsimus.getPunktid();
        }
        else{
            if (võimalus == 1) System.out.println("Vale!");
            else if (võimalus == 2) System.out.println("Vale vastus!");
            else if (võimalus == 3) System.out.println("Ebaõnn!");
            else if (võimalus == 4) System.out.println("Kahjuks eksisid...");
            else if (võimalus == 5) System.out.println("Sinu vastus on vale!");
            else if (võimalus == 6) System.out.println("Vastasid valesti!");
            else if (võimalus == 7) System.out.println("Vastus ei olnud õige!");;
            punktid -= sisestusegaküsimus.getPunktid();
        }
        return punktid;
    }

}
