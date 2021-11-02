#include <stdlib.h>
#include "rect.h"

void main (void) {
 
     Color black = {0, 0, 0};
     Color white = {255, 255, 255};


    Rect* r1 = Rect_New(20, 20, 30, 30, black, white);
    Rect_print(r1);

    Rect* r2 = Rect_New(20, 20, 30, 30, black, white);
    Rect_drag(r2, 10, 100);
    Rect_print(r2);

    free(r1);
    free(r2);
}