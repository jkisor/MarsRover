import org.junit.Test;

import static org.junit.Assert.*;

public class FacingTest
{

    @Test
    public void testTurningLeft()
    {
        Facing facing = new Facing(1,0);

        facing.rotate(-90);

        assertEquals(0, facing.x);
        assertEquals(-1, facing.y);
    }

    @Test
    public void testTurningRight()
    {
        Facing facing = new Facing(1,0);
        facing.rotate(90);

        assertEquals(0, facing.x);
        assertEquals(1, facing.y);
    }
}
