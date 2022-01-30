package org.adligo.i_pipe;

import java.util.Collection;

public interface I_Run<I> {

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
