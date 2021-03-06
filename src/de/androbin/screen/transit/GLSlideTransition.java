package de.androbin.screen.transit;

import static org.lwjgl.opengl.GL11.*;
import de.androbin.shell.gfx.*;
import org.lwjgl.opengl.*;

public final class GLSlideTransition extends GLTransition {
  private final int dx;
  private final int dy;
  
  public GLSlideTransition( final int dx, final int dy, final float duration ) {
    super( duration );
    
    this.dx = dx;
    this.dy = dy;
  }
  
  @ Override
  public float getPauseTime() {
    return 0.5f * duration;
  }
  
  @ Override
  public float getResumeTime() {
    return 0.5f * duration;
  }
  
  @ Override
  public void render( final GLGraphics graphics0, final GLGraphics graphics1 ) {
    final float progress = getTime() / duration;
    
    render( graphics0, progress );
    glLoadIdentity();
    render( graphics1, progress - 1f );
  }
  
  private void render( final GLGraphics graphics, final float progress ) {
    if ( graphics == null ) {
      return;
    }
    
    final int width = Display.getWidth();
    final int height = Display.getHeight();
    
    final float x = dx * progress * width;
    final float y = dy * progress * height;
    
    glPushAttrib( GL_SCISSOR_BIT );
    glScissor( 0, 0, width, height );
    glTranslatef( x, y, 0f );
    glPushMatrix();
    graphics.render();
    glPopMatrix();
    glTranslatef( -x, -y, 0f );
    glPopAttrib();
  }
}