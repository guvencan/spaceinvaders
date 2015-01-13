package spaceinvaders;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Gemi {
    
    private int dx;
    private int dy;
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean visible;
    private Image image;
    private ArrayList fireList;

    public Gemi() {
        image = new ImageIcon(this.getClass().getResource("gemi.png")).getImage();
        
        width = image.getWidth(null);
        height = image.getHeight(null);
        fireList = new ArrayList();
        visible = true;
        x = 512;
        y = 500;

    }
    
    
    
    public void move(){
        
        x += dx;
        y += dy;
        
        if(x<1)
            x=970;
        if(x>970)
            x=1;
        
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }

    public ArrayList getMissiles() {
        return fireList;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isVisible() {
        return visible;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
    
    
    
     public void fire() {
        fireList.add(new Fire(x + height, y + width/2));
    }
    
    
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

       

        if (key == KeyEvent.VK_LEFT) {
            dx = -20;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 20;
        }

        if (key == KeyEvent.VK_UP) {
          dy = -1;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = +1;
        }
    }
    
    
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        
         if (key == KeyEvent.VK_SPACE) {
            fire();
        }
        
      

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
    
    
    
    
}
