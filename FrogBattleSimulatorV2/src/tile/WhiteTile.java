package tile;

import java.awt.*;

/**
 * Клас съдържащ конструктор и метод за визуализиране на елементи "White Tile".
 *
 * @author Озан Осман
 */
public class WhiteTile extends GameTile
{
    /**
     * Конструктор на елемента "White Tile".
     *
     * @param row   ред на елемента
     * @param col   колона на елемента
     * @param color     цвят на елемента
     * @param outlineColor      контур на елемента
     */
    public WhiteTile(int row, int col, Color color, Color outlineColor)
    {
        this.row = row;
        this.col = col;
        this.color = color;
        this.outlineColor = outlineColor;
    }

    /**
     * Метод съдържащ координати за визуализиране на елементи "White Tile".
     *
     * @param g     обект на супер класа за всички графични контексти
     */
    @Override
    public void renderTile(Graphics g)
    {
        int tileX = this.col * TILE_SIZE;
        int tileY = this.row * TILE_SIZE;

        if ((tileY == 0 && tileX == 200) ||
            (tileY == 100 && tileX == 200) ||
            (tileY == 200 && tileX == 0) || (tileY == 200 && tileX == 100) || (tileY == 200 && tileX == 200) || (tileY == 200 && tileX == 300) || (tileY == 200 && tileX == 400) ||
            (tileY == 300 && tileX == 200) ||
            (tileY == 400 && tileX == 200))
        {
            g.setColor(this.color);
            g.fillRect(tileX, tileY, TILE_SIZE, TILE_SIZE);
            g.setColor(this.outlineColor);
            g.drawRect(tileX, tileY, TILE_SIZE, TILE_SIZE);
        }
    }
}
