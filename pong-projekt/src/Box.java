import java.awt.*;
import java.awt.event.*;

public class Box extends Rectangle{

    Color color;

    Box(int x, int y, int width, int height, Color color){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.color=color;
    }

    public void keyPressed(KeyEvent e, int n) {
        int step = 8;
        if(n == 1) {
            if (e.getKeyCode() == KeyEvent.VK_W) {
                this.y = y - step;
            }
            if (e.getKeyCode() == KeyEvent.VK_S) {
                this.y = y + step;
            }
        }
        else if(n == 2) {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                this.y = y - step;
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                this.y = y + step;
            }
        }

    }
    public void draw(Graphics g) {
        g.setColor(this.color);
        g.fillRect(this.x, this.y, this.width, this.height);
    }
}