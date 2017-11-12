package de.androbin.screen.transit;

import static org.lwjgl.opengl.GL11.*;
import de.androbin.shell.gfx.*;
import java.awt.*;
import org.lwjgl.opengl.*;

public final class GLColorCrossfade extends GLTransition {
  private final float red;
  private final float green;
  private final float blue;
  
  public GLColorCrossfade( final Color color, final float crossing, final float duration ) {
    this( color.getRed() / 255f, color.getGreen() / 255f, color.getBlue() / 255f,
        crossing, duration );
  }
  
  public GLColorCrossfade( final float red, final float green, final float blue,
      final float crossing, final float duration ) {
    super( crossing, duration );
    
    this.red = red;
    this.green = green;
    this.blue = blue;
  }
  
  @ Override
  public void render( final GLGraphics graphics0, final GLGraphics graphics1 ) {
    final float time = getTime();
    final float alpha;
    
    if ( time < crossing ) {
      render( graphics0 );
      alpha = time / crossing;
    } else {
      render( graphics1 );
      alpha = ( duration - time ) / ( duration - crossing );
    }
    
    glLoadIdentity();
    
    glColor4f( red, green, blue, alpha );
    
    final int w = Display.getWidth();
    final int h = Display.getHeight();
    
    glBegin( GL_QUADS );
    glVertex2i( 0, 0 );
    glVertex2i( w, 0 );
    glVertex2i( w, h );
    glVertex2i( 0, h );
    glEnd();
  }
  
  private void render( final GLGraphics graphics ) {
    if ( graphics == null ) {
      return;
    }
    
    graphics.render();
  }
}