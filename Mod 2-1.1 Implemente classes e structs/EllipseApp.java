public class EllipseApp {
    public static void main (String[] args) {
        Ellipse e1 = new Ellipse(4,4, 30,20);
        e1.print();
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
        System.out.format("Tamanho da Ellipse (%d,%d) na coordenada (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }
}

