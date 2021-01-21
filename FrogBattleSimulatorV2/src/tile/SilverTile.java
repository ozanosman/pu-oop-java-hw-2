package tile;

import java.awt.*;

/**
 * Клас съдържащ конструктор и метод за визуализиране на елементи "Silver Tile".
 *
 * @author Озан Осман
 */
public class SilverTile extends GameTile
{
    /**
     * Конструктор на елемента "Silver Tile".
     *
     * @param row   ред на елемента
     * @param col   колона на елемента
     * @param color     цвят на елемента
     * @param outlineColor      контур на елемента
     */
    public SilverTile(int row, int col, Color color, Color outlineColor)
    {
        this.row = row;
        this.col = col;
        this.color = color;
        this.outlineColor = outlineColor;
    }

    /**
     * Метод съдържащ координати за визуализиране на елементи "Silver Tile".
     *
     * @param g     обект на супер класа за всички графични контексти
     */
    @Override
    public void renderTile(Graphics g)
    {
        int tileX = this.col * TILE_SIZE;
        int tileY = this.row * TILE_SIZE;

        if ((tileY == 100 && tileX == 0) || (tileY == 100 && tileX == 100) || (tileY == 100 && tileX == 300) || (tileY == 100 && tileX == 400) ||
            (tileY == 300 && tileX == 0) || (tileY == 300 && tileX == 100) || (tileY == 300 && tileX == 300) || (tileY == 300 && tileX == 400))
        {
            g.setColor(this.color);
            g.fillRect(tileX, tileY, TILE_SIZE, TILE_SIZE);
            g.setColor(this.outlineColor);
            g.drawRect(tileX, tileY, TILE_SIZE, TILE_SIZE);
        }
    }
}
