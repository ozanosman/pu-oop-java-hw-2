package tile;

import java.awt.*;

/**
 * Клас наследяващ GameTile, съдържащ конструктор и метод за визуализиране на елемента "Grey Oval Tile".
 *
 * @author Озан Осман
 */
public class GreyOvalTile extends GameTile
{
    /**
     * Конструктор на елемента "Grey Oval Tile".
     *
     * @param row   ред на елемента
     * @param col   колона на елемента
     * @param color     цвят на елемента
     * @param outlineColor      контур на елемента
     */
    public GreyOvalTile(int row, int col, Color color, Color outlineColor)
    {
        this.row = row;
        this.col = col;
        this.color = color;
        this.outlineColor = outlineColor;
    }

    /**
     * Метод съдържащ координати за визуализиране на елемента "Grey Oval Tile".
     *
     * @param g     обект на супер класа за всички графични контексти
     */
    @Override
    public void renderTile(Graphics g)
    {
        g.setColor(this.color);
        g.fillOval(225, 225, TILE_SIZE - 50, TILE_SIZE - 50);
        g.setColor(this.outlineColor);
        g.drawOval(225, 225, TILE_SIZE - 50, TILE_SIZE - 50);
    }
}
