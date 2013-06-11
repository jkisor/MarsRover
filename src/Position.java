import java.awt.*;
public class Position
{
    public int x;
    public int y;

    public Position(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public void move(Point direction)
    {
        x += direction.x;
        y += direction.y;
    }

    public Point asPoint()
    {
        return new Point(x,y);
    }
}