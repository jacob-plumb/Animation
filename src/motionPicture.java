import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class motionPicture {
	
	JFrame frame;
    DrawPanel drawPanel;
	
	private int length = 800;
    private int width = 600;
    ArrayList<Circle> circList = new ArrayList<Circle>();
    ArrayList<Polygon> polyList = new ArrayList<Polygon>();;
    
    //changes center of the illusion
    private int circModX = 0;
    private int circModY = 0;
    
    private int moveCounter = 0;
    private int multY = 1;
    private int multX = 1;
    
    public JSlider slider = new JSlider();
    
    public motionPicture() {
    	circList.add(new Circle(1100));
    	circList.add(new Circle(800));
    	circList.add(new Circle(550));
    	circList.add(new Circle(350));
    	circList.add(new Circle(200));
    	circList.add(new Circle(100));
    	circList.add(new Circle(50));
    	circList.add(new Circle(25));
    	circList.add(new Circle(25, new int[] {0,0,0}));
    	polyList.add(new Polygon(new int[]{length/2 - circModX, 350, 450}, new int[]{width/2 - circModY, width+30, width+30}));
    	polyList.add(new Polygon(new int[]{length/2 - circModX, 350, 450}, new int[]{width/2 - circModY, -30, -30}));
    	
    	slider.setMajorTickSpacing(10);
    	slider.setMinorTickSpacing(1);
    	slider.setPaintTicks(true);
    	slider.setPaintLabels(true);
    	slider.setSnapToTicks(true);
    }
    
	
	public static void main(String[] args) {
        new motionPicture().go();
    }
	

    private void go() {
        frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        drawPanel = new DrawPanel();

        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.NORTH, slider);

        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(length, width);
        frame.setLocation(375, 55);
        animate();
    }
    
    class DrawPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = -3030379568821478211L;
		
		public void paintComponent(Graphics g) {
        	//Background
            g.setColor(Color.lightGray);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            
            for(Circle circ : circList)
            {
            	g.setColor(new Color(circ.getRed(), circ.getGreen(), circ.getBlue()));
            	g.fillOval((length/2) - (circ.getSize()/2) - circModX, (width/2) - (circ.getSize()/2) - circModY, circ.getSize(), circ.getSize());
            }
            
            //g.setColor(Color.black);
            g.setColor(new Color(0, 0, (int)(Math.random()*156)));
            for(Polygon poly : polyList)
            {
            	g.fillPolygon(new int[] {poly.getX(0) - circModX, poly.getX(1), poly.getX(2)}, new int[] {poly.getY(0) - circModY, poly.getY(1), poly.getY(2)}, 3);
            }
            
        }
    }
    
    private void animate() {
        while(true){
        	moveCircles();
            growCircles();
            movePolygon();
            try{
                Thread.sleep(1);
            } catch (Exception exc){}
            frame.repaint();
        }
    }
    
    private void movePolygon()
    {
    	//20 = full speed
    	int moveNum = 20;
    	for(Polygon poly : polyList)
    	{
	    	for(int i = 1; i < 3; i++)
	    	{
	    		if(poly.getY(i) == width + 30 && poly.getX(i) > - 30)
	    		{
	    			poly.setX(i, -moveNum);
	    		}
	    		else if (poly.getX(i) == -30 && poly.getY(i) > -30)
	    		{
	    			poly.setY(i, -moveNum);
	    		}
	    		else if(poly.getY(i) == -30 && poly.getX(i) < length + 30)
	    		{
	    			poly.setX(i, moveNum);
	    		}
	    		else if(poly.getX(i) == length +30 && poly.getY(i) < width +30)
	    		{
	    			poly.setY(i, moveNum);
	    		}
	    	}
    	}
    }
    
    private void growCircles()
    {
    	
    	//making circles bigger
    	for(int i = 0; i < circList.size() - 1; i++)
    	{
    		circList.get(i).incrSize();
    	}
    	
    	//removing circles that are too big
    	if(circList.get(0).getSize() > 1300)
    	{
    		circList.remove(0);
    	}
    	
    	//creating new circle
    	if(circList.get(circList.size()-2).getSize() == 50)
    	{
    		circList.add(circList.size()-1, new Circle(25));
    	}
    }
    
    private void moveCircles()
    {
    	moveCounter++;
    	if(moveCounter%60 == 0)
    	{
    		int yBound = (int)(Math.random()*30);
    		int xBound = (int)(Math.random()*30);
    		if(circModY >= yBound)
    		{
    			multY = -1;
    		}
    		else if (circModY <= -yBound)
    		{
    			multY = 1;
    		}
    		if(circModX >= xBound)
    		{
    			multX = -1;
    		}
    		else if(circModX <= -xBound)
    		{
    			multX = 1;
    		}
    		
    		circModY += multY;
    		circModX += multX;
    	}
    	
    }

    
}
