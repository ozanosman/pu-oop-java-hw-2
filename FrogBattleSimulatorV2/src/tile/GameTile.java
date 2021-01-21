package tile;

import java.awt.*;

/**
 * Абстрактен клас съдържащ променливи и метод за елементи "Orange Tile", "Grey Tile", "Silver Tile", "White Tile" и "Grey Oval Tile".
 *
 * @author Озан Осман
 */
public abstract class GameTile
{
    public static final int TILE_SIZE = 100;

    protected int row;
    protected int col;
    protected Color color;
    protected Color outlineColor;

    /**
     * Метод съдържащ координати за визуализиране на елементи.
     *
     * @param g     обект на супер класа за всички графични контексти
     */
    public abstract void renderTile(Graphics g);
}
