package figures;

import java.awt.*;

public class Rect extends Figure {
    Rectangle rectangle;

    public Rect(int x, int y, int w, int h, Color bdColor, Color flColor) {
        super(x, y, w, h, bdColor, flColor);

        this.rectangle = new Rectangle(this.x, this.y, this.w, this.h);
    }

    public Rect(int x, int y, int w, int h) {
        super(x, y, w, h, Color.BLACK, Color.WHITE);

        this.rectangle = new Rectangle(this.x, this.y, this.w, this.h);
    }

    @Override
    public void Paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setStroke(new BasicStroke(defaultThickness));

        g2d.setColor(flColor);
        g2d.fillRect(this.x, this.y, this.w, this.h);
        
        g2d.setColor(bdColor);
        g2d.drawRect(this.x, this.y, this.w, this.h);
        
    }

    public boolean IsInsideFigure(Point mousePointPosition) {
        return (mousePointPosition.x >= this.x) && (mousePointPosition.x <= this.x + this.w) && (mousePointPosition.y >= this.y) && (mousePointPosition.y <= this.y + this.h);
    }

    public void applyRedSelection(Graphics g) {
        super.applyRedSelection(g);
    }   

    @Override
    public void move(int dx, int dy) {
        super.move(dx, dy);
    }

    @Override
    public void dragFigure(Point mousePointPosition, int dx, int dy) {
        Point pointToResize = new Point(this.x + this.w, this.y + this.h);

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

        this.rectangle.setFrame(this.x, this.y, this.w, this.h);
    }
}
