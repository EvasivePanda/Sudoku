import java.awt.*;
import java.util.Scanner;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class frameClass extends JApplet{
	
	private Scanner userInput = new Scanner(System.in);

	public  frameClass(){
	
		
		 JFrame frame = new JFrame("TEST");
	 	JPanel panel = new GridPanel();
		 panel.setBounds(40,50,600,600);    
         panel.setBackground(Color.gray); 
        
	 	JButton solve = new JButton("Solve");
		 solve.setBackground(Color.cyan);
		   solve.setBounds(00,00,00,0);    
	         solve.setBackground(Color.yellow);  
	   //      solve.setAction(Event.MOUSE_ENTER);
	         panel.add(solve);
	         frame.add(solve);
	         frame.add(panel);  
	        panel.add(solve);
	         solve.setLocation(100, 100);
	         solve.setBounds(40,50,10,60);
             frame.setSize(350,400);    
           frame.setLayout(null);    
            frame.setVisible(true);    
    
 		frame.setSize(600,600);
	 	frame.setVisible(true);
 		frame.setTitle("Sudoku Game");
	 	frame.setResizable(false);
	//	 frame.init(null);
	 	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setLocation(700,100);
		 frame.setLayout(new GridBagLayout());
	}
	
	
	public void makeBoxForGame(String board){
		JFrame frame = new JFrame("TEeST");
		JPanel panel = new GridPanel();
		JLabel label = new JLabel(board);
		panel.setBounds(40,50,500,450);    
        panel.setBackground(Color.red); 
        
		JButton solve = new JButton("Solve:");
		solve.setBackground(Color.cyan);
		  solve.setBounds(50,100,80,30);    
	       solve.setBackground(Color.red);  
	     frame.add(label);
	        panel.add(label);
	        frame.add(panel);  
            frame.setSize(600,600);    
            frame.setLayout(null);    
            frame.setVisible(true); 
    		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	
	public void test(){
		
	         JFrame frame = new JFrame();
	         	frame.setTitle("Sudoku");
	         	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	         	frame.setSize(60000,60000);  
	         	JButton solve = new JButton("Solve");
	    	 	solve.setBackground(Color.cyan);
	    	 	  solve.setBounds(50,1000,1000,30);    
	    	 	        solve.setBackground(Color.yellow);  
	    	//	         solve.setAction(Event.MOUSE_ENTER);	  
	      //   JApplet frame = new frameClass();
		 //	JButton solve = new JButton("Solve");
		 	solve.setBackground(Color.cyan);
		 	  solve.setBounds(50,100,80,30);    
		         solve.setBackground(Color.yellow);  
		   //      solve.setAction(Event.MOUSE_ENTER);
		    //     panel.add(solve);
		   //      frame.add(panel);  
	             frame.setSize(600,600);    
	             frame.setLayout(null);    
	             frame.setVisible(true);  
	    //     applet.setSize(1000, 10000);
	     //    applet.setSize(800, 800);
	        
	 //         frame.init();
	     //    frame.getContentPane().add(applet);
	      //   frame.pack();
	      //   applet.add(solve);
	         frame.setVisible(true);
	        
	    }// end main method
	

	    public void init() {
	         JPanel panel = new GridPanel();
	         getContentPane().add(panel);
	        
	         getContentPane().setSize(8000, 8000);
	    } //end init method
	    
	    
	    class GridPanel extends JPanel {
	          int n = 9;   // Number of cells of my squeare grid
	          int c;
	          
	          public GridPanel() {
	                 setPreferredSize(new Dimension(900, 900));
	                setBackground(Color.white);
	                 c=35;
	          }

	          public void paintComponent(Graphics g) {
	              super.paintComponent(g);
	              Graphics2D g2D = (Graphics2D)g;
	              g2D.setColor(Color.lightGray);
	             //  Set the cell dimension
	              int p=0;
	            
	              int len = c*n;
	              
	              
	             //  Draw the grid
	              for (int i = 0; i <= n; i++) {
	                  g2D.drawLine(0, p, len, p);
	                  g2D.drawLine(p, 0, p, len);
	                  p += c;
	              }
	              
	             // You can paint the (i,j) cell with another color in this way  
	                 int i=8;
	                 int j=0;
	                  g2D.setColor(Color.green);
	                 int x = i*c;
	                 int y = j*c;
	                  g2D.fillRect(x, y, c, c);
	                 g2D.setColor(Color.DARK_GRAY);
	                 Font currentFont = g2D.getFont();
	                 Font newFont = currentFont.deriveFont(currentFont.getSize() * 2.6F);
	                 g2D.setFont(newFont);
	             //    g2D.drawString("8", x+10, y+28);

	              //    g2D.drawLine(x, y, c, c);
	                  g2D.fillRect(x, y, c, c);

	          } //end paintComponent
	     }
	
	    }
