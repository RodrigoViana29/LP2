package figures;

import java.awt.*;

import java.util.ArrayList;
import java.util.Arrays;

import java.io.*;

import interfaces.IVisible;

public abstract class Figure implements IVisible, Serializable {
    protected Color bdColor;
    protected Color flColor;
    protected int x, y;
    protected int w, h;
    protected static float defaultThickness = 2.5f;
    public int flColorIndex = 0;
    public int bdColorIndex = 10;

    ArrayList<Color> flColorPallet = new ArrayList<Color>(
        Arrays.asList(Color.WHITE, Color.GRAY, Color.MAGENTA, Color.BLUE, Color.CYAN, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.RED, Color.DARK_GRAY, Color.BLACK));

    ArrayList<Color> bdColorPallet = new ArrayList<Color>(
        Arrays.asList(Color.WHITE, Color.GRAY, Color.MAGENTA, Color.BLUE, Color.CYAN, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.RED, Color.DARK_GRAY, Color.BLACK));

    protected Figure(int x, int y, int w, int h, Color bdColor, Color flColor) {
        this.x = x;
        this.y = y;

        this.w = w;
        this.h = h;
        
        this.bdColor = bdColor;
        this.flColor = flColor;
    }

    public abstract void Paint(Graphics g);

    public abstract boolean IsInsideFigure(Point mousePointPosition);

    public void applyRedSelection(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setStroke(new BasicStroke(1.5f));

        g2d.setColor(Color.RED);
        g2d.drawRect(this.x, this.y, this.w, this.h);
    }

    public abstract void dragFigure(Point mousePointPosition, int dx, int dy);

    public void move(int dx, int dy) {
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

        int userWidth = gd.getDisplayMode().getWidth();
        int userHeight = gd.getDisplayMode().getHeight();

        if (this.x + dx >= 0 && this.x + dx <= userWidth) {
            this.x += dx;
        }
        
        if (this.y + dy >= 0 && this.y + dy <= userHeight - 100) {
            this.y += dy;
        }
    }

    public void applyFlColorChange() {
        this.flColor = this.flColorPallet.get(this.flColorIndex);
    }   

    public void applyBdColorChange() {
        this.bdColor = this.bdColorPallet.get(this.bdColorIndex);
    }   
}
