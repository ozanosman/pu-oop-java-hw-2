package game;

import piece.FrogLeader;
import piece.FrogGuard;
import tile.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Клас наследяващ JFrame и прилагащ MouseListener, съдържащ конструктор и методи за визуализиране на приложението.
 *
 * @author Озан Осман
 */
public class GameBoard extends JFrame implements MouseListener
{
    public final int TILE_SIDE_COUNT = 5;

    private Object[][] frogLeaderCollection;
    private Object[][] frogGuardCollection;
    private Object selectedFrogLeader;
    private Object selectedFrogGuard;

    private int originalRow;
    private int originalCol;

    /**
     * Конструктор съдържащ характеристиките за създаване на прозореца, в която се визуализира игралната дъска и неговите елементи.
     */
    public GameBoard()
    {
        this.frogLeaderCollection = new Object[TILE_SIDE_COUNT][TILE_SIDE_COUNT];
        this.frogGuardCollection = new Object[TILE_SIDE_COUNT][TILE_SIDE_COUNT];

        this.frogLeaderCollection[0][4] = (new FrogLeader(0, 4, new Color(255, 242,0)));

        this.frogLeaderCollection[4][0] = (new FrogLeader(4, 0, new Color(34, 177,76)));

        this.frogGuardCollection[0][0] = (new FrogGuard(0, 0, new Color(255, 242,0), new Color(34, 177,76)));
        this.frogGuardCollection[0][1] = (new FrogGuard(0, 1, new Color(255, 242,0), new Color(34, 177,76)));
        this.frogGuardCollection[0][2] = (new FrogGuard(0, 2, new Color(255, 242,0), new Color(34, 177,76)));
        this.frogGuardCollection[0][3] = (new FrogGuard(0, 3, new Color(255, 242,0), new Color(34, 177,76)));

        this.frogGuardCollection[4][1] = (new FrogGuard(4, 1, new Color(34, 177,76), new Color(255, 242,0)));
        this.frogGuardCollection[4][2] = (new FrogGuard(4, 2, new Color(34, 177,76), new Color(255, 242,0)));
        this.frogGuardCollection[4][3] = (new FrogGuard(4, 3, new Color(34, 177,76), new Color(255, 242,0)));
        this.frogGuardCollection[4][4] = (new FrogGuard(4, 4, new Color(34, 177,76), new Color(255, 242,0)));

        // Поради някаква странна причина горните плочки не се виждат изцяло.
        this.setTitle("Frog Battle Simulator");
        this.setSize(500,500);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.addMouseListener(this);
    }

    /**
     * Метод, който контролира елементите върху игралната дъска с мишката.
     *
     * @param e     обект на супер класа за всички графични контексти
     */
    @Override
    public void mouseClicked(MouseEvent e)
    {
        int row = this.getBoardCoordinates(e.getY());
        int col = this.getBoardCoordinates(e.getX());

        // Малко е кофти, но работи до някаде, а и е препоръчително да се цъка два пъти с мишката.
        if (this.selectedFrogLeader != null)
        {
            FrogLeader leader = (FrogLeader) this.selectedFrogLeader;

            if (leader.isMoveValid(row, col))
            {
                this.frogLeaderCollection[row][col] = leader;
                leader.moveFrog(row, col);
                this.frogLeaderCollection[originalRow][originalCol] = null;
                this.selectedFrogLeader = null;
            }
        }
        else if (this.selectedFrogGuard != null)
        {
            FrogGuard guard = (FrogGuard) this.selectedFrogGuard;

            if (guard.isMoveValid(row, col))
            {
                this.frogGuardCollection[row][col] = guard;
                guard.moveFrog(row, col);
                this.frogGuardCollection[originalRow][originalCol] = null;
                this.selectedFrogGuard = null;
            }
        }
        this.repaint();

        if (this.hasBoardFrogLeader(row, col) || this.hasBoardFrogGuard(row, col))
        {
            if (this.selectedFrogLeader == null || this.selectedFrogGuard == null)
            {
                this.originalRow = row;
                this.originalCol = col;
            }
            this.selectedFrogLeader = this.getBoardFrogLeader(row, col);
            this.selectedFrogGuard = this.getBoardFrogGuard(row, col);
        }
    }

    @Override
    public void mousePressed(MouseEvent e)
    {

    }

    @Override
    public void mouseReleased(MouseEvent e)
    {

    }

    @Override
    public void mouseEntered(MouseEvent e)
    {

    }

    @Override
    public void mouseExited(MouseEvent e)
    {

    }

    /**
     * Метод съдържащ цикъл за визуализиране на игралната дъска и неговите елементи.
     *
     * @param g     обект на супер класа за всички графични контексти
     */
    @Override
    public void paint(Graphics g)
    {
        // Не успях да удебеля само жабите гардове, затова удебелих всички по-малко.
        ((Graphics2D) g).setStroke(new BasicStroke(2.5f));

        for (int row = 0; row < 5; row++)
        {
            for (int col = 0; col < 5; col++)
            {
                this.renderGameTile(g, row , col);
                this.renderFrogLeader(g, row , col);
                this.renderFrogGuard(g, row , col);
            }
        }
    }

    /**
     * Метод съдържащ инстанции на класове за визуализиране на игралната дъска.
     *
     * @param g     обект на супер класа за всички графични контексти
     * @param row   ред на елемента
     * @param col   колона на елемента
     */
    private void renderGameTile(Graphics g, int row, int col)
    {
        OrangeTile tile1 = new OrangeTile(row, col, new Color(255, 99, 71), Color.BLACK);
        tile1.renderTile(g);

        GreyTile tile2 = new GreyTile(row, col, new Color(68, 68, 68), Color.BLACK);
        tile2.renderTile(g);

        SilverTile tile3 = new SilverTile(row, col, new Color(170, 170, 170), Color.BLACK);
        tile3.renderTile(g);

        WhiteTile tile4 = new WhiteTile(row, col, Color.WHITE, Color.BLACK);
        tile4.renderTile(g);

        GreyOvalTile tile5 = new GreyOvalTile(row, col, new Color(119, 119, 119), Color.BLACK);
        tile5.renderTile(g);
    }

    /**
     * Метод съдържащ инстанция на клас за визуализиране на елемента "Frog Leader".
     *
     * @param g     обект на супер класа за всички графични контексти
     * @param row   ред на елемента
     * @param col   колона на елемента
     */
    private void renderFrogLeader(Graphics g, int row, int col)
    {
        if (this.hasBoardFrogLeader(row, col))
        {
            FrogLeader leader = (FrogLeader) this.getBoardFrogLeader(row, col);
            leader.renderFrog(g);
        }
    }

    /**
     * Метод съдържащ инстанция на клас за визуализиране на елемента "Frog Guard".
     *
     * @param g     обект на супер класа за всички графични контексти
     * @param row   ред на елемента
     * @param col   колона на елемента
     */
    private void renderFrogGuard(Graphics g, int row, int col)
    {
        if (this.hasBoardFrogGuard(row, col))
        {
            FrogGuard guard = (FrogGuard) this.getBoardFrogGuard(row, col);
            guard.renderFrog(g);
        }
    }

    /**
     * Метод, който връща елемент от обекта за елемента "Frog Leader".
     *
     * @param row   ред на елемента
     * @param col   колона на елемента
     */
    private Object getBoardFrogLeader(int row, int col)
    {
        return this.frogLeaderCollection[row][col];
    }

    /**
     * Метод, който връща елемент от обекта за елемента "Frog Guard".
     *
     * @param row   ред на елемента
     * @param col   колона на елемента
     */
    private Object getBoardFrogGuard(int row, int col)
    {
        return this.frogGuardCollection[row][col];
    }

    /**
     * Метод, който проверява и връща елемент от обекта за елемента "Frog Leader", ако той съществува.
     *
     * @param row   ред на елемента
     * @param col   колона на елемента
     */
    private boolean hasBoardFrogLeader(int row, int col)
    {
        return this.getBoardFrogLeader(row, col) != null;
    }

    /**
     * Метод, който проверява и връща елемент от обекта за елемента "Frog Guard", ако той съществува.
     *
     * @param row   ред на елемента
     * @param col   колона на елемента
     */
    private boolean hasBoardFrogGuard(int row, int col)
    {
        return this.getBoardFrogGuard(row, col) != null;
    }


    /**
     * Метод, който връща координати на игралната дъска в единични числа.
     *
     * @param coordinates   координати
     */
    private int getBoardCoordinates(int coordinates)
    {
        return coordinates / GameTile.TILE_SIZE;
    }
}
