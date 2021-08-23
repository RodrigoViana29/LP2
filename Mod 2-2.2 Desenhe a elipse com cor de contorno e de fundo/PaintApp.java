import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

class PaintApp {
    public static void main (String[] args) {
        PaintFrame frame = new PaintFrame();
        frame.setVisible(true);
    }
}

class PaintFrame extends JFrame {
    Ellipse e1,e2,e3;

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
        this.e1 = new Ellipse(50,50, 100,30);
	this.e2 = new Ellipse(100,100, 110,40);
	this.e3 = new Ellipse(150,150, 120,50);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.e1.paint(g);
	this.e2.paint(g);
	this.e3.paint(g);
    }
}

class Ellipse {
    int x, y;
    int w, h;

    Ellipse (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    void print () {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
	g2d.setPaint(Color.red);
	g2d.draw(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
	g2d.setColor(new Color(0,255,0));
	g2d.fill(new Ellipse2D.Double(this.x + 1 ,this.y +1 , this.w - 1,this.h - 1));
    }
    
}