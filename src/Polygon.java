
public class Polygon {
	private int[] x;
    private int[] y;
    
    public Polygon(int[] x, int[] y)
    {
    	this.x = x;
    	this.y = y;
    }
    
    public int getX(int index)
    {
    	return x[index];
    }
    
    public void setX(int index, int num)
    {
    	x[index] += num;
    }
    
    public int getY(int index)
    {
    	return y[index];
    }
    
    public void setY(int index, int num)
    {
    	y[index] += num;
    }
}
