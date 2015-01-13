package spaceinvaders;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private Gemi gemi;
    private ArrayList mantarList;
    private boolean ingame;
    private int B_WIDTH;
    private int B_HEIGHT;
    
    private Image image;
    private int width;
    private int height;

    
    private int[][] pos = { 
        {60, 50}, {130, 50}, {200, 50}, {270, 50},
        {30, 120}, {100, 120}, {170, 120}, {240, 120}, {310, 120},
        {60, 180}, {130, 180}, {200, 180},{270, 180}
     };
    

    public Board() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        image = new ImageIcon(this.getClass().getResource("background.jpg")).getImage();    
    setDoubleBuffered(true);
        ingame = true;
        //setSize(1024,640);
        gemi = new Gemi();
        initAliens();
        timer = new Timer(5, this);
        timer.start();
    }
    
    public void addNotify() {
        super.addNotify();
        B_WIDTH = getWidth();
        B_HEIGHT = getHeight();   
    }

    public void initAliens() {
        mantarList = new ArrayList();

        for (int i=0; i<pos.length; i++ ) {
            mantarList.add(new Mantar(pos[i][0], pos[i][1]));
        }
    }
       
       
     public void paintComponent(Graphics g) {
            g.drawImage(image, width, width, this);
        }
 
     public void checkCollisions() {

        Rectangle r3 = gemi.getBounds();

        for (int j = 0; j<mantarList.size(); j++) {
            Mantar a = (Mantar) mantarList.get(j);
            Rectangle r2 = a.getBounds();

            if (r3.intersects(r2)) {
                gemi.setVisible(false);
                a.setVisible(false);
                ingame = false;
            }
        }

        ArrayList ms = gemi.getMissiles();

        for (int i = 0; i < ms.size(); i++) {
            Fire m = (Fire) ms.get(i);

            Rectangle r1 = m.getBounds();

            for (int j = 0; j<mantarList.size(); j++) {
                Mantar a = (Mantar) mantarList.get(j);
                Rectangle r2 = a.getBounds();

                if (r1.intersects(r2)) {
                    m.setVisible(false);
                    a.setVisible(false);
                }
            }
        }
    }
    
    public void paint(Graphics g) {
        super.paint(g);
   
        if (ingame) {

            Graphics2D g2d = (Graphics2D)g;

            if (gemi.isVisible())
                g2d.drawImage(gemi.getImage(), gemi.getX(), gemi.getY(),
                              this);

            ArrayList ms = gemi.getMissiles();

            for (int i = 0; i < ms.size(); i++) {
                Fire m = (Fire)ms.get(i);
                g2d.drawImage(m.getImage(), m.getX(), m.getY(), this);
            }

            for (int i = 0; i < mantarList.size(); i++) {
                Mantar a = (Mantar)mantarList.get(i);
                if (a.isVisible())
                    g2d.drawImage(a.getImage(), a.getX(), a.getY(), this);
            }

            g2d.setColor(Color.WHITE);
            g2d.drawString("Aliens left: " + mantarList.size(), 5, 15);
            
                    
//            g2d.setColor(Color.WHITE);
//            g2d.drawString(" KARPAT " , 960, 15);


        } else {
              
            String msg = "Game Over";
            Font small = new Font("Helvetica", Font.BOLD, 56);
            FontMetrics metr = this.getFontMetrics(small);

            g.setColor(Color.white);
            g.setFont(small);
            g.drawString(msg, 350,550);
        }

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }


    public void actionPerformed(ActionEvent e) {

        if (mantarList.size()==0) {
            ingame = false;
        }

        ArrayList ms = gemi.getMissiles();

        for (int i = 0; i < ms.size(); i++) {
            Fire m = (Fire) ms.get(i);
            if (m.isVisible()) 
                m.move();
            else ms.remove(i);
        }

        for (int i = 0; i < mantarList.size(); i++) {
            Mantar a = (Mantar) mantarList.get(i);
            if (a.isVisible()) 
                a.move();
            else mantarList.remove(i);
        }

        gemi.move();
        checkCollisions();
        repaint();  
    }

  
   
    private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
            gemi.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            gemi.keyPressed(e);
        }
        
     

        
    
    }
}