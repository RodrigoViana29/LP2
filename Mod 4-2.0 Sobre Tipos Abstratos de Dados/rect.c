#include <stdio.h>
#include <stdlib.h>
#include "rect.h"

struct Figure {
    int x, y;
    int w, h;
    Color bdColor, flColor;
    void (*print) (struct Figure*);
};

typedef void (*Figure_print) (struct Figure*);

struct Rect {
    Figure super;
};

Rect* Rect_New(int x, int y, int w, int h, Color bdColor, Color flColor) {
    Rect* this = malloc(sizeof(Rect));
    Figure* super = (Figure*) this;

    super->x = x;
    super->y = y;
    super->w = w;
    super->h = h;
    super->bdColor = bdColor;
    super->flColor = flColor;
    super->print = (Figure_print) Rect_print;
}

void Rect_print(Rect* this) {
    Figure* super = (Figure*) this;

    printf("Retangulo de tamanho (%d, %d) na posicao (%d, %d).\n",
           super->w, super->h, super->x, super->y);

    printf("Cor de borda: (%d, %d, %d). Cor de fundo: (%d, %d, %d).\n",
        super->bdColor.redColor, super->bdColor.greenColor, super->bdColor.blueColor,
        super->flColor.redColor, super->flColor.greenColor, super->flColor.blueColor);
}

void Rect_drag(Rect* this, int dx, int dy) {
    Figure* super = (Figure*) this;

    super->x += dx;
    super->y += dy;
}