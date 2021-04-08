import java.awt.*;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

public class Peaklass{
    public static void main(String[] args) throws Exception{


        //Loome valmis kõik küsimused
        Küsimus nädalaPäev = new Küsimus("Mis päev on kaks päeva enne päeva, mis järgneb kohe päevale kolm päeva enne päeva, mis on kaks päeva pärast päeva kohe enne reedet?", new String[]{"pühapäev", "teisipäev", "neljapäev"}, 1, 10);
        Küsimus arvud = new Küsimus("Mu õde oli 10 aastat tagasi minust kaks korda vanem, nüüd on ta 26-aastane. Kui vana ma olen?",new String[]{"18-aastane", "16-aastane", "13-aastane"}, 0, 10);
        Küsimus kolmnurgad = new Küsimus("Mitu kolmnurka on pildil?", new String[]{"27","25", "17"}, 0, 10, "kolmnurgad.jpg");
        Küsimus ruudud = new Küsimus("Mitu ruutu on pildil?", new String[]{"10","11", "12"}, 1, 10, "ruudud.jpg");
        Küsimus misMaOlen = new Küsimus("Kui mind korrutatakse suvalise numbriga, on vastuses olevate numbrite summa alati mina ise. Mis ma olen?", new String[]{"1", "9", "2"}, 1, 10);
        Küsimus mitmesKoht = new Küsimus("Sa möödud jooksuvõistlusel teisel kohal jooksvast jooksjast. Mitmendal kohal sa oled?", new String[]{"Sõltub osalejate arvust", "1.", "2."}, 2, 10);
        Küsimus kuubik = new Küsimus("Milline kuubik vastab antud pinnalaotusele?", new String[]{"a","b","c","d"}, 3, 10, "kuubik.jpg");
        Küsimus blokid = new Küsimus("Mitmest kuubikust koosneb antud kujund?", new String[]{"a","b","c","d","e"},3,10, "blokid.jpg");
        Küsimus lipp1 = new Küsimus("Mis riigi lipuga on tegu?", new String[]{"Horvaatia", "Sloveenia", "Slovakkia"}, 2,10, "slovakkia.jpg");
        Küsimus lipp2 = new Küsimus("Mis riigi lipuga on tegu?", new String[]{"Moldova", "Rumeenia", "Venezuela"},2, 10, "venezuela.jpg");
        Küsimus pealinn1 = new Küsimus("Millise riigi pealinn on Skopje?", new String[]{"Põhja-Makedoonia", "Bulgaaria", "Moldova"}, 0, 10);
        Küsimus pealinn2 = new Küsimus("Millise riigi pealinn on Bern?", new String[]{"Austria", "Šveits", "Tšehhi"}, 1, 10);

        //Mäng toimub kahes voorus, esimeses on tekstiküsimused, teises pildiküsimused, paneme need vastavatesse massiividesse
        Küsimus[] küsimused1 = new Küsimus[]{nädalaPäev, arvud, misMaOlen, mitmesKoht, pealinn1, pealinn2};
        Küsimus[] küsimused2 = new Küsimus[]{ruudud, kolmnurgad, kuubik, blokid, lipp1, lipp2};

        int punktid = 0;//Algne punktiskoor

        //Esimene küsimustevoor
        for (int i = 0; i < küsimused1.length; i++) {
            voor(i+1, punktid);//Abimeetod, väljastab, mitmenda vooruga on tegemist ja kui palju mängijal punkte on
            TimeUnit.SECONDS.sleep(1);//Väike delay sujuvama kogemuse tagamiseks
            JList list = new JList(new String[] {küsimused1[i].getVastusevariandid()[0], küsimused1[i].getVastusevariandid()[1], küsimused1[i].getVastusevariandid()[2]});
            //Kasutame JOptionPane, et väljastada kõik vastusevariandid
            UIManager.put("OptionPane.minimumSize",new Dimension(800,100));//Küsimusakna suurus
            JOptionPane.showMessageDialog(//Kuvab küsimuse ja vastusevariandid
                    null, list, küsimused1[i].getKüsimus(), JOptionPane.PLAIN_MESSAGE);
            punktid = õigeVastus(küsimused1[i], list.getSelectedIndex(),punktid);
            //getSelectedIndex() annab meile märku, millise vastuse mängija valis ja abimeetodi õigeVastus abiga vaatame, kas see oli õige ning liidame/lahutame vastavad punktid
        }
        System.out.println("Said esimesest plokist kokku " + punktid + " punkti!");
        System.out.println("Edasi tuleb pildiküsimuste plokk.");

        //Teine (pildiküsimuste) voor
        for (int i = 0; i < küsimused2.length; i++) {
            voor(i+1+küsimused1.length, punktid);
            TimeUnit.SECONDS.sleep(2);
            JFrame f=new JFrame();//Loome JFrame, et saaks kuvada pilti
            f.setPreferredSize(new Dimension(800, 800));//Pildiraami suurus
            f.pack();
            String proov = küsimused2[i].getFailinimi();//Saab get-meetodiga failinime, milles on pilt
            f.add(new JLabel(new ImageIcon(proov)));
            f.setVisible(true);
            JList list = new JList(new String[]{küsimused2[i].getVastusevariandid()[0], küsimused2[i].getVastusevariandid()[1], küsimused2[i].getVastusevariandid()[2]});
            //Samamoodi, nagu eelmises tsüklis, kuvame vastusevariandid
            if (küsimused2[i].getVastusevariandid().length == 4) {//Kui vastusevariante on 4, siis muudame listi
                list = new JList(new String[]{küsimused2[i].getVastusevariandid()[0], küsimused2[i].getVastusevariandid()[1], küsimused2[i].getVastusevariandid()[2], küsimused2[i].getVastusevariandid()[3]});
            }
            else if (küsimused2[i].getVastusevariandid().length == 5) {//Kui vastusevariante on 5, siis muudame listi
                list = new JList(new String[]{küsimused2[i].getVastusevariandid()[0], küsimused2[i].getVastusevariandid()[1], küsimused2[i].getVastusevariandid()[2], küsimused2[i].getVastusevariandid()[3], küsimused2[i].getVastusevariandid()[4]});
            }
            UIManager.put("OptionPane.minimumSize",new Dimension(800,100));
            JOptionPane.showMessageDialog(//Kuvab küsimuse ja vastusevariandid
                    null, list, küsimused2[i].getKüsimus(), JOptionPane.PLAIN_MESSAGE);//Küsimusakna suurus
            f.dispose();//Sulgeb pildi
            punktid = õigeVastus(küsimused2[i], list.getSelectedIndex(),punktid);//Kontrollib, kas vastus oli õige
        }
        System.out.println("Said mälumängust kokku " + punktid + " punkti!");//Lõppskoor
    }//main


    public static void voor(int mitmes, int punktid){//Abimeetod
        System.out.println("Käimas on " + mitmes + ". voor!");
        System.out.println("Punktiskoor: " + punktid + " punkti");
    }

    public static int õigeVastus(Küsimus küsimus, int vastus, int punktid){//Abimeetod, tagastab uue punktide arvu vastavalt sellele, kas vastus oli õige või vale
        int võimalus = 1 + (int)(Math.random()*((7-1) + 1));//Suvaline number 1st 7ni, et tagasiside igakord seesama ei oleks
        if (küsimus.getVastus() == vastus){//Kui vastus on õige
            if (võimalus == 1) System.out.println("Tubli!");
            else if (võimalus == 2) System.out.println("Hea töö!");
            else if (võimalus == 3) System.out.println("LETS GO!!!");
            else if (võimalus == 4) System.out.println("Õige vastus!");
            else if (võimalus == 5) System.out.println("Vapustav!");
            else if (võimalus == 6) System.out.println("Õige!");
            else if (võimalus == 7) System.out.println("Õige vastus! Jätka samas vaimus!");
            punktid += küsimus.getPunktid();//.. siis lisatakse küsimuse punktid
        }
        else{//Kui vastus on vale
            if (võimalus == 1) System.out.println("Vale!");
            else if (võimalus == 2) System.out.println("Vale vastus!");
            else if (võimalus == 3) System.out.println("Ebaõnn!");
            else if (võimalus == 4) System.out.println("Kahjuks eksisid...");
            else if (võimalus == 5) System.out.println("Sinu vastus on vale!");
            else if (võimalus == 6) System.out.println("Vastasid valesti!");
            else if (võimalus == 7) System.out.println("Vastus ei olnud õige!");
            punktid -= küsimus.getPunktid();//.. siis lahutatakse küsimuse punktid
        }
        return punktid;//Tagastame uue punktiskoori
    }


}
