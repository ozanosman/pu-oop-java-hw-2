package piece;

import java.awt.*;

/**
 * Абстрактен клас съдържащ променливи и методи за елементи "Frog Leader" и "Frog Guard".
 *
 * @author Озан Осман
 */
public abstract class Frog
{
    public final int FROG_SIZE = 50;

    protected int row;
    protected int col;
    protected Color color;
    protected Color outlineColor;

    /**
     * Метод съдържащ координати и цвят на елементи.
     *
     * @param g     обект на супер класа за всички графични контексти
     */
    public abstract void renderFrog(Graphics g);

    /**
     * Метод, който проверява и връща дали елемента може да се движи.
     *
     * @param moveRow   ред на елемента, който може да се движи
     * @param moveCol   колона на елемента, който може да се движи
     */
    public abstract boolean isMoveValid(int moveRow, int moveCol);

    /**
     * Метод, който дава нови координати на елементи.
     *
     * @param row   нов ред на елемента
     * @param col   нова колона на елемента
     */
    public abstract void moveFrog(int row, int col);
}
