#include <stdio.h>

typedef struct {
  int x, y;
  int w, h;
} Rect;

void print (Rect* r) {
  printf("Base e Altura do retangulo (%d,%d) na coordenada (%d,%d).\n",
    r->w,r->h, r->x,r->y);
}

void main (void) {
    Rect r1 = { 4,4, 30,20 };
    print(&r1);
}
