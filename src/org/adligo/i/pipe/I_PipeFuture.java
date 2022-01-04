package org.adligo.i.pipe;

public interface I_PipeFuture<I,O> {
	public O run(I in);
}
