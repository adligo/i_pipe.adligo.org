package org.adligo.i.pipe;

import java.util.function.Consumer;
import java.util.function.Function;

public interface I_PipeSegment<I,O> {

	<B,R> I_PipeSegment<I,O> decision(Consumer<? super B> consumer);

	<B,R> I_PipeSegment<I,O> decision(Function<? super B, ? extends R> mapper);
	
	<B> I_PipeSegment<I,O>  then(Consumer<? super B> consumer);
	
	<B,R> I_PipeSegment<I,R> then(Function<? super B, ? extends R> mapper);
	
	
}
