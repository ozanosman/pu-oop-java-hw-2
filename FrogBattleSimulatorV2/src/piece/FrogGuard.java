package piece;

import tile.GameTile;

import java.awt.*;

/**
 * Клас съдържащ конструктор и методи за визуализиране на елементи "Frog Guard".
 *
 * @author Озан Осман
 */
public class FrogGuard extends Frog
{
    /**
     * Конструктор на елемента "Frog Guard".
     *
     * @param row   ред на елемента
     * @param col   колона на елемента
     * @param color     цвят на елемента
     * @param outlineColor      контур на елемента
     */
    public FrogGuard(int row, int col, Color color, Color outlineColor)
    {
        this.row = row;
        this.col = col;
        this.color = color;
        this.outlineColor = outlineColor;
    }

    /**
     * Метод съдържащ координати и цвят на елементи "Frog Guard".
     *
     * @param g     обект на супер класа за всички графични контексти
     */
    @Override
    public void renderFrog(Graphics g)
    {
        int frogX = this.col * GameTile.TILE_SIZE;
        int frogY = this.row * GameTile.TILE_SIZE;

        g.setColor(this.color);
        g.fillOval(frogX + 25, frogY + 25, FROG_SIZE, FROG_SIZE);
        g.setColor(this.outlineColor);
        g.drawOval(frogX + 25, frogY + 25, FROG_SIZE, FROG_SIZE);
    }

    /**
     * Метод, който проверява и връща дали елемента може да се движи.
     *
     * @param moveRow   ред на елемента, който може да се движи
     * @param moveCol   колона на елемента, който може да се движи
     */
    @Override
    public boolean isMoveValid(int moveRow, int moveCol)
    {
        int rowCoefficient = Math.abs(moveRow - this.row);
        int colCoefficient = Math.abs(moveCol - this.col);

        return rowCoefficient == 0 && colCoefficient == 1 || rowCoefficient == 1 && colCoefficient == 0;
    }

    /**
     * Метод, който дава нови координати на елементи "Frog Guard".
     *
     * @param row   нов ред на елемента
     * @param col   нова колона на елемента
     */
    @Override
    public void moveFrog(int row, int col)
    {
        this.row = row;
        this.col = col;
    }
}
