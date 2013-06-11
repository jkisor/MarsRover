import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class GridTest
{
    private Grid grid;

    @Before
    public void setup()
    {
        grid = new Grid(10, 10);
    }
    @Test
    public void addingObstacle()
    {
        Point obstaclePos = new Point(1,0);

        grid.obstacles.add(obstaclePos);

        assertTrue(grid.hasObstacleAt((Point)obstaclePos.clone()));
        assertTrue(!grid.hasObstacleAt(new Point(0,0)));
    }
    
    @Test
    public void testRightSideWrapping()
    {
        Position position = new Position(9, 0);

        position.move(new Point(1, 0));
        position = grid.enforceWrappingBounds(position);

        assertEquals(0, position.x);
    }

    @Test
    public void testBottomWrapping()
    {
        Position position = new Position(0, 9);
        position.move(new Point(0, 1));
        position = grid.enforceWrappingBounds(position);

        assertEquals(0, position.y);
    }

    @Test
    public void testLeftWrapping()
    {
        Position position = new Position(0, 0);

        position.move(new Point(-1, 0));
        position = grid.enforceWrappingBounds(position);

        assertEquals(grid.width-1, position.x);
    }

    @Test
    public void testTopWrapping()
    {
        Position position = new Position(0, 0);

        position.move(new Point(0, -1));
        position = grid.enforceWrappingBounds(position);

        assertEquals(grid.height-1, position.y);
    }
}
