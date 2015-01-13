package spaceinvaders;



import javax.swing.ImageIcon;
import javax.swing.JFrame;         

public class main extends JFrame {

    public main() {
        add(new Board());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1024,640);
        setLocationRelativeTo(null);
        setTitle("KARPAT");
        setResizable(false);
        setVisible(true);
        
    }

    public static void main(String[] args) {
        new main();
    }
}