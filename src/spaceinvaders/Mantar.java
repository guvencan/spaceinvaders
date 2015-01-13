package spaceinvaders;



import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Mantar {
    
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean visible;
    private Image image;
    
    public Mantar(int x, int y) {
        image = new ImageIcon(this.getClass().getResource("mantar.png")).getImage();
        width = image.getWidth(null);
        height = image.getHeight(null);
        visible = true;
        this.x = x;
        this.y = y;
    }
    
    public void move() {
      
        x += 100;
        if(x>1000)
            x=0;
       
    }
    
      public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Image getImage() {
        return image;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    
}
