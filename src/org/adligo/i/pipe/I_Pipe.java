package org.adligo.i.pipe;

import java.util.function.Function;

/**
 * Note that  I_Pipe is almost identical to a java.util.stream.Stream
 * the main difference is that it MAY be executed (supplied) at a later time
 * and also mimics a list of steps with the then method. 
 * @author scott
 *
 * @param <T>
 */
public interface I_Pipe<I,O> extends Function<I,O>, I_Run<I> {
	

	<B,R> I_Pipe<I,R> decision(Function<? super O, ? extends R> mapper);
	
	
	<B,R> I_Pipe<I,R> then(Function<? super O, ? extends R> mapper);
}
