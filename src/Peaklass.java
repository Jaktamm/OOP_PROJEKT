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
        Küsimus kolmnurgad = new Küsimus("Mitu kolmnurka on pildil?", new String[]{"27","25", "17"}, 0, 10);
        Küsimus ruudud = new Küsimus("Mitu ruutu on pildil?", new String[]{"10","11", "12"}, 2, 10);
        SisestusegaKüsimus proov1 = new SisestusegaKüsimus("Mis päev täna on?", "pühapäev", 10);


        int punktid = 0;
        voor(1, punktid);

        JFrame f=new JFrame();
        JButton button = new JButton();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setContentPane(button);
        button.addActionListener(e -> {
            f.dispose();
        });
        f.setPreferredSize(new Dimension(400, 400));
        f.pack();
        f.add(new JLabel(new ImageIcon("pilt.jpg"))); //Selle reaga saab lihtsalt pilte lisada
        f.setVisible(true);

        JList list = new JList(new String[] {rebane.getVastusevariandid()[0], rebane.getVastusevariandid()[1], rebane.getVastusevariandid()[2]});
        JOptionPane.showMessageDialog(
                null, list, rebane.getKüsimus(), JOptionPane.PLAIN_MESSAGE);
       punktid = õigeVastus(rebane, list.getSelectedIndex(),punktid);
       // proovisin viivitust, ilma pealeklikkimiseta hetkel ei saanud akent kinni,
        // äkki anda kasutajale juhised, et peab aknale klikkama
        TimeUnit.SECONDS.sleep(3);

        voor(2, punktid);
        // väike delay teeb väljastuse paremaks
        TimeUnit.SECONDS.sleep(1);

        // 2. voor, katsetus
        JFrame K2 =new JFrame();
        JButton button2 = new JButton();
        K2.setContentPane(button2);
        button2.addActionListener(e -> {
            K2.dispose();
        });
        K2.setPreferredSize(new Dimension(600, 600));
        K2.pack();
        K2.add(new JLabel(new ImageIcon("nädalapäevad.jpg"))); //Selle reaga saab lihtsalt pilte lisada
        K2.setVisible(true);

        JList list2 = new JList(new String[] {nädalaPäev.getVastusevariandid()[0], nädalaPäev.getVastusevariandid()[1], nädalaPäev.getVastusevariandid()[2]});
        JOptionPane.showMessageDialog(
                null, list2, nädalaPäev.getKüsimus(), JOptionPane.PLAIN_MESSAGE);
        punktid = õigeVastus(nädalaPäev, list2.getSelectedIndex(),punktid);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TimeUnit.SECONDS.sleep(3);

        // proovisin sisestust, sellisel kujul toimib ja saaksime soovi korral ka seda kasutada
        voor(3, punktid);
        TimeUnit.SECONDS.sleep(1);
        String sisestuseks = JOptionPane.showInputDialog(null, proov1.getKüsimus(), "3. voor",
                JOptionPane.QUESTION_MESSAGE);
        punktid = SisestuseKontroll(proov1,sisestuseks,punktid);
        TimeUnit.SECONDS.sleep(1);

        voor(4,punktid);
        TimeUnit.SECONDS.sleep(1);
    }

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
