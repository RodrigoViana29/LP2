package handlers;

import figures.*;

import java.awt.event.*;
import java.awt.Point;

import java.util.ArrayList;

public class KeyButtonHandler {
    private static final int defaultSize = 100;
    
    private class KeyButtons {
        private static final int DEL = 127;
        private static final int TAB = 9; 
        private static final int UP = 38;
        private static final int DOWN = 40;
        private static final int LEFT = 37;
        private static final int RIGHT = 39;
        private static final int PAGEUP = 33;
        private static final int PAGEDOWN = 34;
        private static final int PERIOD = 46;
        private static final int COMMA = 44;
    }

    public static Figure KeyButtonPressed(KeyEvent keyEvent, ArrayList<Figure> figures, Figure selectedFigure, Point mousePointPosition) {
        if (keyEvent.getKeyChar() == 'r') {
            Rect rectangle = new Rect(mousePointPosition.x, mousePointPosition.y, defaultSize, defaultSize);
            figures.add(rectangle);
        } else if (keyEvent.getKeyChar() == 'e') {
            Ellipse ellipse = new Ellipse(mousePointPosition.x, mousePointPosition.y, defaultSize, defaultSize);
            figures.add(ellipse);
        } else if (keyEvent.getKeyChar() == 't') {
            Triangle triangle = new Triangle(mousePointPosition.x, mousePointPosition.y, defaultSize, defaultSize);
            figures.add(triangle);
        } else if (keyEvent.getKeyChar() == 'l') {
            Line line = new Line(mousePointPosition.x, mousePointPosition.y, defaultSize);
            figures.add(line);
        } else if (keyEvent.getKeyCode() == KeyButtons.TAB) {
            if (selectedFigure == null) {
                if (figures.size() > 0) {
                    selectedFigure = figures.get(0);
                }
            } else {
                selectedFigure = figures.get((figures.indexOf(selectedFigure) + 1) % figures.size());
            }
        } else if (selectedFigure != null) {
            if (keyEvent.getKeyCode() == KeyButtons.UP) {
                selectedFigure.move(0, -10);
            } else if (keyEvent.getKeyCode() == KeyButtons.DOWN) {
                selectedFigure.move(0, 10);
            } else if (keyEvent.getKeyCode() == KeyButtons.LEFT) {
                selectedFigure.move(-10, 0);
            } else if (keyEvent.getKeyCode() == KeyButtons.RIGHT) {
                selectedFigure.move(10, 0);
            } else if (keyEvent.getKeyCode() == KeyButtons.DEL) {
                figures.remove(selectedFigure);        
                selectedFigure = null; 
            } else if (keyEvent.getKeyCode() == KeyButtons.PAGEUP) {
                selectedFigure.flColorIndex++;

                if (selectedFigure.flColorIndex > 10) {
                    selectedFigure.flColorIndex %= 11;
                }

                selectedFigure.applyFlColorChange();
            } else if (keyEvent.getKeyCode() == KeyButtons.PAGEDOWN) {
                selectedFigure.flColorIndex--;

                if (selectedFigure.flColorIndex < 0) {
                    selectedFigure.flColorIndex += 11;
                }

                selectedFigure.applyFlColorChange();
            } else if (keyEvent.getKeyCode() == KeyButtons.PERIOD) {
                selectedFigure.bdColorIndex++;

                if (selectedFigure.bdColorIndex > 10) {
                    selectedFigure.bdColorIndex %= 11;
                }

                selectedFigure.applyBdColorChange();
            } else if (keyEvent.getKeyCode() == KeyButtons.COMMA) {
                selectedFigure.bdColorIndex--;

                if (selectedFigure.bdColorIndex < 0) {
                    selectedFigure.bdColorIndex += 11;
                }

                selectedFigure.applyBdColorChange();
            }
        }

        return selectedFigure;
    }
}
