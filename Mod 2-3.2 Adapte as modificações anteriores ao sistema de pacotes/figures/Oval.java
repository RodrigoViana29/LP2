package figures;

import java.awt.*;

public class Oval {
    private int x, y;
    private int w, h;

    public Oval (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public void print () {
        System.out.format("Circulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
	g2d.setPaint(Color.red);
        g2d.drawOval(this.x,this.y, this.w,this.h);
	g2d.setColor(new Color(0,255,0));
	g2d.fillOval(this.x + 1,this.y + 1, this.w - 1,this.h - 1);
    }
}