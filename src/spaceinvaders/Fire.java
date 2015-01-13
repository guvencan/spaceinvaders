package spaceinvaders;


import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Fire {
    
    private int x;
    private int y;
    boolean visible;
    private int height;
    private int width;
    private Image image;
    
    
    private final int BOARD_HEIGHT = 1000;
    private final int FIRE_SPEED = 2;

    public Fire(int x,int y) {
        
        image= new ImageIcon(this.getClass().getResource("fire.jpg")).getImage();
        visible=true;
        width = image.getWidth(null);
        height = image.getHeight(null);
        this.x = x-25;
        this.y = y;
        
        
    }
    
    public Image getImage() {
        return image;
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

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
    
     public void move() {
        y -= FIRE_SPEED;
        if (y < 25)
            visible = false;
    }
    
    
    
    
    
}

