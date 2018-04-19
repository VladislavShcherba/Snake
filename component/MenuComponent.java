package component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;

import util.GlobalConstants;

public class MenuComponent extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public MenuComponent() {
		
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension( GlobalConstants.MENU_WIDTH, GlobalConstants.MENU_HEIGHT );
	}
	
	public static void main( String... args ) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame frame = new JFrame();
				TextButton button = new TextButton("Hello gyuz!", GlobalConstants.MENU_BUTTON_WIDTH, GlobalConstants.MENU_BUTTON_HEIGHT,
						new Font(GlobalConstants.MENU_BUTTON_FONT_NAME, GlobalConstants.MENU_BUTTON_FONT_STYLE, GlobalConstants.MENU_BUTTON_FONT_SIZE),
						Color.BLACK, Color.LIGHT_GRAY, Color.YELLOW );
				frame.add( button );
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				frame.pack();
			}
		});
	}
	
}