package TRABALHO.sectors;

import TRABALHO.Position;
import TRABALHO.personages.Enemie;

public abstract class Sector extends Position {

    // Atributos
    protected char[] sides;
    protected boolean hasX;
    protected boolean showSector;
    protected boolean isCenter;
    protected int amountOfEnemies;
    protected Enemie[] enemies; 
    protected boolean hasSinglePlayer;
    protected boolean hasSupportPlayer;
    
    // Construtor
    public Sector(int lin, int col, char[] sides, boolean hasX, int amountOfEnemies, boolean hasSinglePlayer,
            boolean hasSupportPlayer, boolean showSector, boolean isCenter) {
        super(lin, col);
        this.sides = sides;
        this.hasX = hasX;
        this.amountOfEnemies = amountOfEnemies;
        this.hasSinglePlayer = hasSinglePlayer;
        this.hasSupportPlayer = hasSupportPlayer;
        this.showSector = showSector;
        this.isCenter = isCenter;
    }

    // Getters e Setters
    public char[] getSides() {
        return sides;
    }

    public void setSides(char[] sides) {
        this.sides = sides;
    }

    public boolean isHasX() {
        return hasX;
    }

    public void setHasX(boolean hasX) {
        this.hasX = hasX;
    }

    public int getAmountOfEnemies() {
        return amountOfEnemies;
    }

    public void setAmountOfEnemies(int amountOfEnemies) {
        this.amountOfEnemies = amountOfEnemies;
    }

    public boolean isHasSinglePlayer() {
        return hasSinglePlayer;
    }

    public void setHasSinglePlayer(boolean hasSinglePlayer) {
        this.hasSinglePlayer = hasSinglePlayer;
    }

    public boolean isHasSupportPlayer() {
        return hasSupportPlayer;
    }

    public void setHasSupportPlayer(boolean hasSupportPlayer) {
        this.hasSupportPlayer = hasSupportPlayer;
    }

    public boolean isShowSector() {
        return showSector;
    }

    public void setShowSector(boolean showSector) {
        this.showSector = showSector;
    }

    public boolean isCenter() {
        return isCenter;
    }

    public void setCenter(boolean isCenter) {
        this.isCenter = isCenter;
    }
}
