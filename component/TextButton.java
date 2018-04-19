package component;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Rectangle2D;

import javax.swing.JButton;


public class TextButton extends JButton {

	private static final long serialVersionUID = 1L;
	
	private String text;
	private int width, height;
	private Font font;
	private Color primaryColor, highlightedColor, pressedColor;
	private boolean mouseEntered, mousePressed;
	
	private class ColorChangeListener implements MouseListener {

		@Override
		public void mouseClicked( MouseEvent event ) {}
		
		@Override
		public void mouseEntered( MouseEvent event ) {
			mouseEntered = true;
			repaint();
		}

		@Override
		public void mouseExited( MouseEvent event ) {
			mouseEntered = false;
			mousePressed = false;
			repaint();
		}

		@Override
		public void mousePressed( MouseEvent event ) {
			mousePressed = true;
			repaint();
		}

		@Override
		public void mouseReleased( MouseEvent event ) {
			mousePressed = false;
			repaint();
		}
	}
	
	public TextButton( String text, int width, int height, Font font, Color primaryColor, Color highlightedColor, Color pressedColor ) {
		this.text = text;
		this.width = width;
		this.height = height;
		this.font = font;
		this.primaryColor = primaryColor;
		this.highlightedColor = highlightedColor;
		this.pressedColor = pressedColor;
		addMouseListener( new ColorChangeListener() );
	}
	
	@Override
	public void paint( Graphics g ) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setFont( font );
		FontRenderContext context = g2.getFontRenderContext();
		Rectangle2D bounds = font.getStringBounds( text, context );
		LineMetrics metrics = font.getLineMetrics( text, context );
		int ascent = (int) metrics.getAscent();
		int descent = (int) metrics.getDescent();
		int textWidth = (int) bounds.getWidth();
		int textHeight = ascent + descent;
		int x = ( width - textWidth ) / 2;
		int y = ( height - textHeight ) / 2 + ascent;
		
		if( mousePressed ) {
			g2.setColor( pressedColor );
			
		} else if( mouseEntered ) {
			g2.setColor( highlightedColor );
		} else {
			g2.setColor( primaryColor );
		}
		g2.drawString( text, x, y );
		g2.setStroke(new BasicStroke(5) );
		g2.draw( new Rectangle2D.Double(0, 0, width, height) );
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension( width, height );
	}
}