import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class motionPicture {
	
	JFrame frame;
    DrawPanel drawPanel;
	
	private int length = 800;
    private int width = 600;
    private int[] circSizes = {50, 50, 100, 200, 350, 550, 800, 1100};
    ArrayList<Circle> circList = new ArrayList<Circle>();
    
    //issue for some reason
    //circList.add(new Circle(50, new int[]{0, 0, 0}));
    
    Color[] colors= {
    		new Color(66, 66, 66), //dark grey
    		new Color(114, 114, 114), //med grey
    		new Color(196, 196, 196), // light grey
    		new Color(71, 38, 12), //dark brown
    		new Color(122, 66, 22), //med brown
    		new Color(206, 126, 64), //light brown
    		new Color(255, 192, 155) //super light brown
    		
    };
	
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
            
            //Hole 7
            g.setColor(colors[6]);
            g.fillOval((length/2) - (circSizes[7]/2), (width/2) - (circSizes[7]/2), circSizes[7], circSizes[7]);
            
            //Hole 6
            g.setColor(colors[5]);
            g.fillOval((length/2) - (circSizes[6]/2), (width/2) - (circSizes[6]/2), circSizes[6], circSizes[6]);
            
            //Hole 5
            g.setColor(colors[4]);
            g.fillOval((length/2) - (circSizes[5]/2), (width/2) - (circSizes[5]/2), circSizes[5], circSizes[5]);
            
            //Hole 4
            g.setColor(colors[3]);
            g.fillOval((length/2) - (circSizes[4]/2), (width/2) - (circSizes[4]/2), circSizes[4], circSizes[4]);
            
            //Hole 3
            g.setColor(colors[2]);
            g.fillOval((length/2) - (circSizes[3]/2), (width/2) - (circSizes[3]/2), circSizes[3], circSizes[3]);
            
            //Hole 2
            g.setColor(colors[1]);
            g.fillOval((length/2) - (circSizes[2]/2), (width/2) - (circSizes[2]/2), circSizes[2], circSizes[2]);
            
            //Hole 1
            g.setColor(colors[0]);
            g.fillOval((length/2) - (circSizes[1]/2), (width/2) - (circSizes[1]/2), circSizes[1], circSizes[1]);
            
            //Hole 0
            g.setColor(Color.black);
            g.fillOval((length/2) - (circSizes[0]/2), (width/2) - (circSizes[0]/2), circSizes[0], circSizes[0]);
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
    	for(int i = 1; i < circSizes.length; i++)
    	{
    		if(circSizes[i] < 1300) {
    			circSizes[i] += 1;
    		}
    	}
    }

    
}
