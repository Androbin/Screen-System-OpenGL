package de.androbin.screen;

import static org.lwjgl.opengl.GL11.*;
import de.androbin.screen.transit.*;
import de.androbin.shell.*;
import de.androbin.shell.gfx.*;

public class GLScreenManager extends SmoothScreenManager<GLTransition> implements GLGraphics {
  @ Override
  public void render() {
    glLoadIdentity();
    
    if ( transit == null ) {
      final Shell screen = current();
      
      if ( screen != null ) {
        final GLGraphics graphics = (GLGraphics) screen;
        graphics.render();
      }
    } else {
      final Shell screen0 = transit.screen0;
      final Shell screen1 = transit.screen1;
      
      final GLGraphics graphics0 = (GLGraphics) screen0;
      final GLGraphics graphics1 = (GLGraphics) screen1;
      
      transit.transition.render( graphics0, graphics1 );
    }
  }
}