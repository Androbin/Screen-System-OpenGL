package de.androbin.screen.transit;

import de.androbin.shell.gfx.*;

public abstract class OpenGLTransition extends Transition {
  public OpenGLTransition( final float crossing, final float duration ) {
    super( crossing, duration );
  }
  
  public abstract void render( OpenGLGraphics graphics0, OpenGLGraphics graphics1 );
}