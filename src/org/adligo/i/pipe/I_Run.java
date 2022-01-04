package org.adligo.i.pipe;

import java.util.Collection;
import java.util.function.Consumer;

public interface I_Run<I> {

	/**
	 * A terminal operation on the pipeline
	 * @param <B>
	 * @param <R>
	 * @param consumer
	 * @return
	 */
	<B,R> I_Run<I> decision(Consumer<? super B> consumer);
	
	/**
	 * A terminal operation on the pipeline
	 * @param <B>
	 * @param consumer
	 * @return
	 */
	<B> I_Run<I> then(Consumer<? super B> consumer);
	
	/**
	 * Run the pipeline after it's creation
	 * @param in
	 */
	public void supply(I in);
	
	/**
	 * Run the pipeline after it's creation
	 * @param in
	 */
	public void supply(Collection<I> in);
}
