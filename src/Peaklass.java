import java.awt.*;
import javax.swing.*;

public class Peaklass{

    public static void main(String[] args) {
        Küsimus rebane = new Küsimus("Mis on pildil?", new String[]{"Rebane", "Lehm", "Ilves"}, 0, 10);

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

        JList küsimus1 = new JList(new String[] {rebane.getVastusevariandid()[0], rebane.getVastusevariandid()[1], rebane.getVastusevariandid()[2]});
        JOptionPane.showMessageDialog(
                null, küsimus1, rebane.getKüsimus(), JOptionPane.PLAIN_MESSAGE);
        punktid = õigeVastus(rebane, küsimus1.getSelectedIndex(),punktid);

        voor(2, punktid);
    }

    public static void voor(int mitmes, int punktid){
        System.out.println("Käimas on " + mitmes + ". voor!");
        System.out.println("Punktiskoor: " + punktid + " punkti");
    }

    public static int õigeVastus(Küsimus küsimus, int vastus, int punktid){
        if (küsimus.getVastus() == vastus){
            System.out.println("Tubli!");
            punktid += küsimus.getPunktid();
        }
        else{
            System.out.println("Jobu!");
            punktid -= küsimus.getPunktid();
        }
        return punktid;
    }

}
