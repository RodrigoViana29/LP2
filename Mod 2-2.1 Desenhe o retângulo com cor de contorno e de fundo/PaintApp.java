import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class PaintApp {
    public static void main (String[] args) {
        PaintFrame frame = new PaintFrame();
        frame.setVisible(true);
    }
}

class PaintFrame extends JFrame {
    Rect r1,r2,r3;

    PaintFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Painting Figures");
        this.setSize(350, 350);
	this.getContentPane().setBackground(Color.blue);
        this.r1 = new Rect(50,50, 100,30);
	this.r2 = new Rect(100,100, 110,40);
	this.r3 = new Rect(150,150, 120,50);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
	this.r2.paint(g);
	this.r3.paint(g);
    }
}

class Rect {
    int x, y;
    int w, h;

    Rect (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
	g2d.setPaint(Color.red);
	g2d.drawRect(this.x,this.y, this.w,this.h);
	g2d.setColor(new Color(0,255,0));
	g2d.fillRect(this.x + 1 ,this.y +1 , this.w - 1,this.h - 1);
    }
    
}