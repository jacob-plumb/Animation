import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

final public class Animate {
	
	//variable for number of dots, arraylist filled with dot objects 

    JFrame frame;
    DrawPanel drawPanel;

    private int oneX = 200; // Starting X coordinate
    private int oneY = 200; // Starting Y coordinate
    
    private int length = 300;
    private int width = 500;
    private int speed = 1;

    boolean up = false;
    boolean down = true;
    boolean left = false;
    boolean right = true;
    
    //private int numDots = 1;
    //ArrayList<Dot> dotList = new ArrayList<Dot>();

    public static void main(String[] args) {
        new Animate().go();
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
        moveDot();
    }

    class DrawPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = -3030379568821478211L;
		
		public void paintComponent(Graphics g) {
        	//White Border
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            //Black Border
            g.setColor(Color.BLACK);
            g.fillRect(3, 3, this.getWidth()-6, this.getHeight()-6);
            //Inside Color
            g.setColor(Color.GREEN);
            g.fillRect(6, 6, this.getWidth()-12, this.getHeight()-12);
            
            //Dot
            g.setColor(Color.BLUE);
            g.fillRect(oneX, oneY, 6, 6); // This is the dot
            //g.fillRect(oneX, oneY, 6, 10);
            //g.fillRect(oneX, oneY, 10, 6);
        }
    }

    private void moveDot() {
        while(true){
            checkBounds();
            moveLoc();
            try{
                Thread.sleep(10);
            } catch (Exception exc){}
            frame.repaint();
        }
    }
    private void moveLoc(){
    	if(up){
            oneY-=speed;
        }
        if(down){
            oneY+=speed;
        }
        if(left){
            oneX-=speed;
        }
        if(right){
            oneX+=speed;
        }	
    }
    private void checkBounds(){
    	if(oneX >= length - 17){
            right = false;
            left = true;
        }
        if(oneX <= 7){
            right = true;
            left = false;
        }
        if(oneY >= width - 41){
            up = true;
            down = false;
        }
        if(oneY <= 7){
            up = false;
            down = true;
        }	
    }
}