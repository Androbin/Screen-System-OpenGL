package de.androbin.screen;

import de.androbin.screen.transit.*;
import de.androbin.shell.*;
import de.androbin.shell.gfx.*;

public final class OpenGLScreenManager extends SmoothScreenManager<OpenGLTransition> implements OpenGLGraphics {
  @ Override
  public void render() {
    if ( transit == null ) {
      final Shell screen = current();
      
      if ( screen != null ) {
        final OpenGLGraphics graphics = (OpenGLGraphics) screen;
        graphics.render();
      }
    } else {
      final Shell screen0 = transit.screen0;
      final Shell screen1 = transit.screen1;
      
      final OpenGLGraphics graphics0 = (OpenGLGraphics) screen0;
      final OpenGLGraphics graphics1 = (OpenGLGraphics) screen1;
      
      transit.transition.render( graphics0, graphics1 );
    }
  }
}