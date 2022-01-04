package org.adligo.i.pipe;

import java.util.List;

/**
 * Note that  I_Pipe is almost identical to a java.util.stream.Stream
 * the main difference is that it MAY be executed (supplied) at a later time
 * and also mimics a list of steps with the then method. 
 * @author scott
 *
 * @param <T>
 */
public interface I_Pipe<I> {
	
}
