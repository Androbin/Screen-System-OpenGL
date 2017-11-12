package de.androbin.screen.transit;

import de.androbin.shell.gfx.*;

public abstract class GLTransition extends Transition {
  public GLTransition( final float crossing, final float duration ) {
    super( crossing, duration );
  }
  
  public abstract void render( GLGraphics graphics0, GLGraphics graphics1 );
}