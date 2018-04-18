package component;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.Timer;

import driver.Driver;
import util.Direction;
import util.GlobalPreferences;


public class GraphicsComponent extends JComponent {

	private class DirectionChangeAction extends AbstractAction {
		
		private static final long serialVersionUID = 1L;
		
		Direction direction;
		
		DirectionChangeAction( Direction direction ) {
			this.direction = direction;
		}
		
		@Override
		public void actionPerformed( ActionEvent event ) {
			driver.changeSnakeDirection( direction );
		}	
	}
	
	private static final long serialVersionUID = 1L;

	private Driver driver;
	private Timer timer;
	
	public GraphicsComponent() {
		driver = new Driver();
		timer = new Timer( 1000 / GlobalPreferences.getSpeed(), new ActionListener(){
			@Override
			public void actionPerformed( ActionEvent event ) {
				if( driver.handleNextStep() ) {
					System.exit(1);
				} else {
					repaint();
				}
			}
		});
		timer.start();
		initControlKeys();
	}
	
	@Override
	public void paintComponent( Graphics g ) {
		driver.draw(g);
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension( GlobalPreferences.getWidth()*GlobalPreferences.getCellSize(), GlobalPreferences.getHeight()*GlobalPreferences.getCellSize() ); 
	}
	
	private void initControlKeys() {
		InputMap inputMap = getInputMap( JComponent.WHEN_IN_FOCUSED_WINDOW );
		inputMap.put( KeyStroke.getKeyStroke("pressed UP"), "pressed UP" );
		inputMap.put( KeyStroke.getKeyStroke("pressed DOWN"), "pressed DOWN" );
		inputMap.put( KeyStroke.getKeyStroke("pressed RIGHT"), "pressed RIGHT" );
		inputMap.put( KeyStroke.getKeyStroke("pressed LEFT"), "pressed LEFT" );
		inputMap.put( KeyStroke.getKeyStroke("pressed PAUSE"), "pressed PAUSE" );
		
		ActionMap actionMap = getActionMap();
		actionMap.put( "pressed UP", new DirectionChangeAction(Direction.UP) );
		actionMap.put( "pressed DOWN", new DirectionChangeAction(Direction.DOWN) );
		actionMap.put( "pressed RIGHT", new DirectionChangeAction(Direction.RIGHT) );
		actionMap.put( "pressed LEFT", new DirectionChangeAction(Direction.LEFT) );
		actionMap.put( "pressed PAUSE", new AbstractAction() {
			private static final long serialVersionUID = 1L;
			@Override
			public void actionPerformed( ActionEvent event ) {
				if( timer.isRunning() ) {
					timer.stop();
				} else {
					timer.start();
				}
			}
		});
	}
}
