package org.adligo.i_pipe;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * A Context interface that MAY be aggregated with other 
 * context interfaces, which provides context creation methods
 * for pipes.
 * 
 * Known Implementations 
 * @see {@link org.adligo.pipe.PipeCtx}
 * @author scott
 *
 */
public interface I_PipeCtx {

  <PI, PO> I_Pipe<PI, PO> newPipe(Consumer<PI> consumer);

  <PI, PO> I_Pipe<PI, PO> newPipe(Consumer<PI> consumer, String name);
  
  <PI> I_Run<PI> newPipe(Class<PI> inClazz, Consumer<PI> consumer) ;

  <PI> I_Run<PI> newPipe(Class<PI> inClazz, 
  		Consumer<PI> consumer, String name);
  
  <PI, PO> I_Pipe<PI, PO> newPipe(Function<PI, PO> fun);

  <PI, PO> I_Pipe<PI, PO> newPipe(Function<PI, PO> fun, String name);
  
  <PI, PO> I_Pipe<PI, PO> newPipe(Class<PI> inClazz, Class<PO> outClazz, 
  		Function<PI, PO> fun);

  <PI, PO> I_Pipe<PI, PO> newPipe(Class<PI> inClazz, Class<PO> outClazz, 
  		Function<PI, PO> fun, String name);
}
