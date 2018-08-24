
public class Circle {
	private int size;
	private int[] rgb = new int[3];
	
	public static void main(String[] args)
	{
		Circle circle = new Circle(5);
		System.out.println("" + circle.getRed() + ", " + circle.getGreen() + ", " + circle.getBlue());
	}
	
	public Circle(int size)
	{
		this.size = size;
		genRandColor();
	}
	
	public Circle(int size, int[] rgb)
	{
		this.size = size;
		this.rgb = rgb;
	}
	
	public int getSize()
	{
		return size;
	}
	
	public void setSize(int size)
	{
		this.size = size;
	}
	
	public void incrSize(int incr)
	{
		size += incr;
	}
	
	public int getRed()
	{
		return rgb[0];
	}
	
	public int getGreen()
	{
		return rgb[1];
	}
	
	public int getBlue()
	{
		return rgb[2];
	}
	
	public void genRandColor()
	{
		for(int i = 0; i < rgb.length; i++)
		{
			int x = (int)(Math.random()*256);
			rgb[i] = x;
		}
	}
	
}
