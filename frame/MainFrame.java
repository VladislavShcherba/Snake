package frame;

import java.awt.EventQueue;

import javax.swing.JFrame;

import component.GraphicsComponent;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public MainFrame() {
		add( new GraphicsComponent() );
		pack();
		
	}
	
	public static void main(String... args) {
		EventQueue.invokeLater(new Runnable(){
			@Override
			public void run() {
				JFrame frame = new MainFrame();
				frame.setTitle("Square");
	            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            frame.setVisible(true);
			}	
		});
	}
	
}
