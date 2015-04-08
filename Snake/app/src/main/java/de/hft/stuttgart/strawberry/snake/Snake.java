package de.hft.stuttgart.strawberry.snake;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.hardware.SensorEvent;
import android.widget.Switch;

import java.util.ArrayList;

/**
 * Created by Tommy_2 on 26.03.2015.
 * Erstellt die Schlange als Objekt.
 */
public class Snake {

    private ArrayList<Point> position = new ArrayList<Point>();
    private int level;

    public Snake(ArrayList<Point> pos){
        setPosition(pos);
    }

    // Zeichnet die Schlange
    public void drawSnakeDots(Canvas canvas){
        Paint snakePaint = new Paint();
        snakePaint.setColor(Color.BLUE);

        for(Point currentPoint : position){
            canvas.drawCircle(currentPoint.x,currentPoint.y,20,snakePaint);
        }
    }

    // Bewegt die Schlange
    public void moveSnake(Movement direction){

        /*
         Durchläuft die Positionen Rückwärts (Vom letzten zum ersten Wert)
         Dise Schleife zieht alle Dots hinter dem Kopf nach
          */
        for(int i = this.position.size()-1; i > 0; i--){
            this.position.get(i).x = this.position.get(i-1).x;
            this.position.get(i).y = this.position.get(i-1).y;
        }

            if(direction.isUp()){
                this.position.get(0).y -=20;
            } if(direction.isDown()){
                this.position.get(0).y +=20;
            } if(direction.isRight()){
                this.position.get(0).x +=20;
            } if(direction.isLeft()){
                this.position.get(0).x -=20;
            }
    }

    // Setter und Getter
    public ArrayList<Point> getPosition() {
        return position;
    }

    public void setPosition(ArrayList<Point> position) {
        this.position = position;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
