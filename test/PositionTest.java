import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class PositionTest
{
    @Test
    public void testMovingRight()
    {
        Position position = new Position(0, 0);
        position.move(new Point(1,0));
        assertEquals(1, position.x);
    }

    @Test
    public void testMovingLeft()
    {
        Position position = new Position(1, 0);
        position.move(new Point(-1,0));
        assertEquals(0, position.x);
    }

    @Test
    public void testMovingUp()
    {
        Position position = new Position(0, 1);
        position.move(new Point(0,-1));
        assertEquals(0, position.y);
    }

    @Test
    public void testMovingDown()
    {
        Position position = new Position(0, 0);
        position.move(new Point(0,1));
        assertEquals(1, position.y);
    }
}
