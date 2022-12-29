package TRABALHO.personages;

import TRABALHO.Position;

public abstract class Personage extends Position{
    
    // Atributos
    protected int attack;
    protected int defense;
    protected boolean isAlive;
    
    // Construtor
    public Personage(int lin, int col, int attack, int defense, boolean isAlive) {
        super(lin, col);
        this.attack = attack;
        this.defense = defense;
        this.isAlive = isAlive;
    }

    // Getters e Setters
    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    // Métodos
    public abstract void move();

    public abstract void attack();

    public abstract void search();
}
