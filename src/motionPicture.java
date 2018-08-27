import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class motionPicture {
	
	JFrame frame;
    DrawPanel drawPanel;
	
	private int length = 800;
    private int width = 600;
    //private int[] circSizes = {50, 50, 100, 200, 350, 550, 800, 1100};
    ArrayList<Circle> circList = new ArrayList<Circle>();
    
    public motionPicture() {
    	circList.add(new Circle(1100));
    	circList.add(new Circle(800));
    	circList.add(new Circle(550));
    	circList.add(new Circle(350));
    	circList.add(new Circle(200));
    	circList.add(new Circle(100));
    	circList.add(new Circle(50));
    	circList.add(new Circle(50, new int[] {0,0,0}));
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
            
        }
    }
    
    private void animate() {
        while(true){
            growCircles();
            try{
                Thread.sleep(10);
            } catch (Exception exc){}
            frame.repaint();
        }
    }
    
    private void growCircles()
    {
    	//making circles bigger
    	for(int i = 0; i < circList.size() - 1; i++)
    	{
    		//put increment number inside of incrSize() function depending on how big the circle is
    		circList.get(i).incrSize(1);
    	}
    	
    	//removing circles that are too big
    	if(circList.get(0).getSize() > 1300)
    	{
    		circList.remove(0);
    	}
    	
    	//creating new circle
    	if(circList.get(circList.size()-2).getSize() == 100)
    	{
    		circList.add(circList.size()-1, new Circle(50));
    	}
    }

    
}
