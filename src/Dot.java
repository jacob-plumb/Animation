
public class Dot {
	
	private boolean up = false;
    private boolean down = true;
    private boolean left = false;
    private boolean right = true;
    
    private int speed = 1;
    
    private int oneX = 200; // Starting X coordinate
    private int oneY = 200; // Starting Y coordinate
    
    public Dot(boolean up, boolean down, boolean left, boolean right, int speed, int x, int y)
    {
    	this.up = up;
    	this.down = down;
    	this.left = left;
    	this.right = right;
    	this.speed = speed;
    	oneX = x;
    	oneY = y;
    }
    
    public void switchX()
    {
    	right = !right;
		left = !left;
    }
    
    public void switchY()
    {
    	up = !up;
    	down = !down;
    }
    
    public void setSpeed(int speed)
    {
    	this.speed = speed;
    }
    
    public int getSpeed()
    {
    	return speed;
    }
    
    public int getX()
    {
    	return oneX;
    }
    
    public int getY()
    {
    	return oneY;
    }
}
