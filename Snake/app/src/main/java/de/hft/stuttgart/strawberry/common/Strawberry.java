package de.hft.stuttgart.strawberry.common;

import android.graphics.Point;

import de.hft.stuttgart.strawberry.views.GPSingleSurfaceView;

/**
 * Created by Tommy_2 on 06.04.2015.
 * Erstellt die Erdbeere als Objekt
 */
public class Strawberry {

    // Spielfeld
    private int [][] playingField;
    private Point berryPosition;

    // Constructor
    public Strawberry(int [][]playingField){
        this.playingField = playingField;
        this.berryPosition = new Point();
    }

    public void createBerryPosition(){

        // Zufallspunkte
        int xKoordinate = (int) ((Math.random()* Constants.XTILE_COUNT-1));
        int yKoordinate = (int) ((Math.random()* Constants.YTILE_COUNT-1));

        // Prüft ob Wert auf Schlange erzeugt wird
        if(playingField[xKoordinate][yKoordinate] != 2){
            this.berryPosition.x = xKoordinate;
            this.berryPosition.y = yKoordinate;
        } else {
            createBerryPosition();
        }
    }

    // Zeichnet Spiel beim ersten Player
    public void drawBerry(){
        this.playingField[berryPosition.x][berryPosition.y] = 1;
    }

    public Point getBerryPosition() {
        return berryPosition;
    }

    public void setBerryPosition(Point berryPosition) {
        this.berryPosition = berryPosition;
    }
}
