public class RectApp {
    public static void main (String[] args) {
        Rect r1 = new Rect(4,4, 30,20);
	r1.print();
	r1.area();
	r1.drag(2,2);
	
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
    int area (){
	 int area = this.w * this.h;
	 System.out.format("A area do retangulo � : (%d).\n",area);
	 return area;
     }	
     void drag(int dx,int dy){
	this.x = this.x + dx;
	this.y = this.y + dy;
	System.out.format("A nova posicao � : (%d,%d).\n",this.x,this.y);
     }
	
     
}