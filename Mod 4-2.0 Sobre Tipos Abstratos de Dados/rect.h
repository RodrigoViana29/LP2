typedef struct Color {
    int redColor, greenColor, blueColor;
} Color;

typedef struct Figure Figure;

typedef void (*Figure_print) (struct Figure*);

typedef struct Rect Rect;

Rect* Rect_New(int, int, int, int, Color, Color);
void Rect_print(Rect*);
void Rect_drag(Rect*, int dx, int dy);