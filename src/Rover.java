class Rover
{
    public Position position;
    public Facing facing;
    private Grid grid;
    private boolean obstacleHit;

    public Rover(Position position, Facing facing, Grid grid)
    {
        this.position = position;
        this.facing = facing;
        this.grid = grid;
        this.obstacleHit = false;
    }

    public void executeCommands(String commandString)
    {
        for (int i = 0; i < commandString.length(); i++)
        {
            char cmd = commandString.charAt(i);

            switch(cmd )
            {
                case 'f':
                    moveForward();
                    break;
                case 'b':
                    moveBackwards();
                    break;
                case 'l':
                    facing.rotate(-90);
                    break;
                case 'r':
                    facing.rotate(90);
                    break;
                default:
                    break;
            }
            if(obstacleHit)
            {
                obstacleHit = false;
                return;
            }
        }
    }

    private void moveBackwards()
    {
        position.move(facing.back());

        if(grid.hasObstacleAt(position.asPoint()))
            position.move(facing.forward());
    }

    private void moveForward()
    {
        position.move(facing.forward());

        if(grid.hasObstacleAt(position.asPoint()))
            position.move(facing.back());
    }
}
