package de.androbin.screen.transit;

import static org.lwjgl.opengl.GL11.*;
import de.androbin.shell.gfx.*;
import org.lwjgl.opengl.*;

public final class OpenGLSlideTransition extends OpenGLTransition {
  private final int dx;
  private final int dy;
  
  public OpenGLSlideTransition( final int dx, final int dy,
      final float crossing, final float duration ) {
    super( crossing, duration );
    
    this.dx = dx;
    this.dy = dy;
  }
  
  @ Override
  public void render( final OpenGLGraphics graphics0, final OpenGLGraphics graphics1 ) {
    final float time = getTime();
    final float progress;
    
    if ( time < crossing ) {
      progress = 0.5f * time / crossing;
    } else {
      progress = 0.5f + 0.5f * ( time - crossing ) / ( duration - crossing );
    }
    
    render( graphics0, progress );
    render( graphics1, progress - 1f );
  }
  
  private void render( final OpenGLGraphics graphics, final float progress ) {
    if ( graphics == null ) {
      return;
    }
    
    final float x = dx * progress * Display.getWidth();
    final float y = dy * progress * Display.getHeight();
    
    glPushMatrix();
    glTranslatef( x, y, 0f );
    graphics.render();
    glPopMatrix();
  }
}