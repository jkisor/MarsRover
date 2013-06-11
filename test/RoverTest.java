import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class RoverTest
{
    Grid grid;

    @Before
    public void setup()
    {
        grid = new Grid(10, 10);
    }

    private Rover createRightFacingRoverAt(int x, int y)
    {
        Position position = new Position(x, y);
        Facing facing = new Facing(1,0);
        return new Rover(position, facing, grid);
    }

    @Test
    public void processSingleForwardCommand()
    {
        Rover rover = createRightFacingRoverAt(0, 0);
        rover.executeCommands("f");
        assertEquals(1, rover.position.x);

    }

    @Test
    public void processMultipleCommands()
    {
        Rover rover = createRightFacingRoverAt(0, 0);
        rover.executeCommands("ffb");
        assertEquals(1, rover.position.x);
    }

    @Test
    public void processBackCommand()
    {
        Position position = new Position(2, 0);
        Facing facing = new Facing(1, 0);
        Rover rover = new Rover(position, facing, grid);
        rover.executeCommands("b");
        assertEquals(1, rover.position.x);

    }

    @Test
    public void processForwardAndBackwardCommands()
    {
        Rover rover = createRightFacingRoverAt(0, 0);
        rover.executeCommands("fb");
        assertEquals(0, rover.position.x);

    }

    @Test
    public void processLeftCommands()
    {
        Rover rover = createRightFacingRoverAt(0, 0);
        rover.executeCommands("l");
        assertEquals(0, rover.facing.x);
        assertEquals(-1, rover.facing.y);

    }

    @Test
    public void processRightCommands()
    {
        Rover rover = createRightFacingRoverAt(0, 0);
        rover.executeCommands("r");
        assertEquals(0, rover.facing.x);
        assertEquals(1, rover.facing.y);

    }

    @Test
    public void processMultipleRotationCommands()
    {
        Rover rover = createRightFacingRoverAt(0, 0);
        rover.executeCommands("lrlr");
        assertEquals(1, rover.facing.x);
        assertEquals(0, rover.facing.y);
    }

    @Test
    public void processFourLeftCommands()
    {
        Rover rover = createRightFacingRoverAt(0, 0);
        rover.executeCommands("llll");
        assertEquals(1, rover.facing.x);
        assertEquals(0, rover.facing.y);

    }

    @Test
    public void forwardMovingRoverStopsIfObstacleEncountered()
    {
        Rover rover = createRightFacingRoverAt(0, 0);
        grid.obstacles.add(new Point(2, 0));
        rover.executeCommands("ffffff");
        assertEquals(1, rover.position.x);
    }

    @Test
    public void backwardMovingRoverStopsIfObstacleEncountered()
    {
        Rover rover = createRightFacingRoverAt(2, 0);
        grid.obstacles.add(new Point(0, 0));
        rover.executeCommands("bbbbb");
        assertEquals(1, rover.position.x);
    }
}


