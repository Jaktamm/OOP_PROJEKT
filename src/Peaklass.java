import java.awt.*;
import javax.swing.JFrame;

public class Peaklass extends Canvas{

    public static void main(String[] args) {
        Peaklass m =new Peaklass();
        JFrame f=new JFrame();
        f.add(m);
        f.setSize(400,400);
        f.setVisible(true);
    }

    public void paint(Graphics g) {

        Toolkit t=Toolkit.getDefaultToolkit();
        Image i=t.getImage("pilt.jpg");
        g.drawImage(i, 120,100,this);

    }

    public void voor(int mitmes, int punktid){
        System.out.println("Käimas on " + mitmes + ". voor!");
        System.out.println("Punktiskoor: " + punktid + " punkti");
        System.out.println("Tere");
    }

}
