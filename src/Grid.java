import java.awt.*;
import java.util.Vector;

public class Grid
{
    public int width;
    public int height;

    public Vector<Point> obstacles;

    public Grid(int width, int height)
    {
        this.width = width;
        this.height = height;

        obstacles = new Vector<Point>();
    }

    public boolean hasObstacleAt(Point queryPos)
    {
        for(int i = 0; i < obstacles.size(); i++)
        {
            Point current = obstacles.get(i);
            if(current.x == queryPos.x &&
                    current.y == queryPos.y)
                return true;
        }
        return false;
    }

    public Position enforceWrappingBounds(Position position)
    {
        wrapXAxis(position);
        wrapYAxis(position);

        return position;
    }

    private void wrapYAxis(Position position)
    {
        if (position.y < 0)
            position.y = height - 1;
        else
            position.y %= height;
    }

    private void wrapXAxis(Position position)
    {
        if (position.x < 0)
            position.x = width - 1;
        else
            position.x %= width;
    }
}
