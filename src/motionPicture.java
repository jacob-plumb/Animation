import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class motionPicture {
	
	JFrame frame;
    DrawPanel drawPanel;
	
	private int length = 800;
    private int width = 600;
    ArrayList<Circle> circList = new ArrayList<Circle>();
    private int centerCirc = 0;
    
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
    }
    
	
	public static void main(String[] args) {
        new motionPicture().go();
    }
	

    private void go() {
        frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        drawPanel = new DrawPanel();

        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);

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
            	g.fillOval((length/2) - (circ.getSize()/2), (width/2) - (circ.getSize()/2), circ.getSize(), circ.getSize());
            }
            
            g.setColor(Color.black);
            g.fillRect((length/2) - 4, (width/2) - 5, 10, width);
            g.fillPolygon(new int[] {401, 350, 450}, new int[] {288, 600, 600}, 3);
            
            g.fillOval(0, 500, 800, 200);
            
        }
    }
    
    private void animate() {
        while(true){
            growCircles();
            try{
                Thread.sleep(5);
            } catch (Exception exc){}
            frame.repaint();
        }
    }
    
    private void growCircles()
    {
    	
    	/* THIS INCREASES THE SIZE OF THE CENTER HOLE
    	 * if(centerCirc%15 == 0)
    		{
    			circList.get(circList.size()-1).incrSize();
    		}
    		enterCirc++;
    	 */
    	
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

    
}
