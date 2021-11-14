package figures;

import java.awt.*;

public class Triangle extends Figure {
    Polygon triangle;
    int xArray[], yArray[];

    public Triangle(int x, int y, int w, int h, Color bdColor, Color flColor) {
        super(x, y, w, h, bdColor, flColor);
    }

    public Triangle(int x, int y, int w, int h) {
        super(x, y, w, h, Color.BLACK, Color.WHITE);
    }

    @Override
    public void Paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        int x1 = this.x;
        int y1 = this.y;
        int x2 = x1;
        int y2 = y1 + this.h;
        int x3 = x1 + this.w;
        int y3 = y1 + this.h;

        int xValues[] = {x1, x2, x3};
        int yValues[] = {y1, y2, y3};

        this.xArray = xValues;
        this.yArray = yValues;
        
        this.triangle = new Polygon(xArray, yArray, 3);
        
        g2d.setStroke(new BasicStroke(defaultThickness));

        g2d.setColor(flColor);
        g2d.fillPolygon(this.triangle);

        g2d.setColor(bdColor);
        g2d.drawPolygon(this.triangle);
    }

    @Override
    public boolean IsInsideFigure(Point mousePointPosition) {
        return this.triangle.contains(mousePointPosition);
    }

    @Override
    public void applyRedSelection(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setStroke(new BasicStroke(defaultThickness));

        g2d.setColor(Color.RED);
        g2d.drawPolygon(this.xArray, this.yArray, 3);
    }   

    @Override
    public void move(int dx, int dy) {
        super.move(dx, dy);
    }

    @Override
    public void dragFigure(Point mousePointPosition, int dx, int dy) {
        Point pointToResize = new Point(this.xArray[2], this.yArray[2]);

        if (pointToResize.distance(mousePointPosition) <= 5) {
            if (this.w + dx >= 10) {
                this.w += dx;
            }

            if (this.h + dy >= 10) {
                this.h += dy;
            }
        } else {
            move(dx, dy);
        }

        int x1 = this.x;
        int y1 = this.y;
        int x2 = x1;
        int y2 = y1 + this.h;
        int x3 = x1 + this.w;
        int y3 = y1 + this.h;

        int xValues[] = {x1, x2, x3};
        int yValues[] = {y1, y2, y3};

        this.xArray = xValues;
        this.yArray = yValues;
    }
}
