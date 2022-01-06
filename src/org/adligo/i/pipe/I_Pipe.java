package org.adligo.i.pipe;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Note that  I_Pipe is almost identical to a java.util.stream.Stream
 * the main difference is that it MAY be executed (supplied) at a later time
 * and also mimics a list of steps with the then method. 
 * 
 * Known Implementations 
 * {@link org.adligo.pipe.PipeCtx}
 * 
 * @author scott
 *
 * @param <I> input
 * @param <O> output
 */
public interface I_Pipe<I,O> extends I_Run<I> {
		
  I_Pipe<I,O> distinct();

  I_Pipe<I,O> distinct(String name);
	
	/**
	 * A special note I think the filters in  java.util.stream.Streams
	 * are backward, if I want a coffee filter, the goal is to keep 
	 * the coffee out of the coffee pot :) 
	 * 
	 * @param predicate
	 * @return
	 */
	I_Pipe<I,O> filter(Predicate<? super O> predicate);

	/**
	 * A special note I think the filters in  java.util.stream.Streams
	 * are backward, if I want a coffee filter, the goal is to keep 
	 * the coffee out of the coffee pot :) 
	 * 
	 * @param predicate
	 * @param name
	 * @return
	 */
	I_Pipe<I,O> filter(Predicate<? super O> predicate, String  name);	
	
	/**
	 * A fork in the road (aka a choice or decision)
	 * A terminal operation
	 * @param <B>
	 * @param <R>
	 * @param consumer
	 * @return
	 */
	I_Run<I> fork(Consumer<? super O> consumer);

	/**
	 * A fork in the road (aka a choice or decision)
	 * A terminal operation
	 * @param consumer
	 * @param name
	 * @return
	 */
	I_Run<I> fork(Consumer<? super O> consumer, String name);
	
	/**
	 * A fork in the road (aka a choice or decision)
	 * A terminal operation
	 * @param <B>
	 * @param <R>
	 * @param mapper
	 * @return
	 */
	<B,R> I_Pipe<I,R> fork(Function<? super O, ? extends R> mapper);
	
	/**
	 * A fork in the road (aka a choice or decision)
	 * A terminal operation
	 * @param <B>
	 * @param <R>
	 * @param mapper
	 * @param name
	 * @return
	 */
	<B,R> I_Pipe<I,R> fork(Function<? super O, ? extends R> mapper, String name);
	
	/**
	 * Run the pipeline after it's creation
	 * @param in
	 */
	public Optional<O> get(I in);

	/**
	 * Run the pipeline after it's creation
	 * @param in
	 */
	public Optional<O> get(I ... in);

	/**
	 * Run the pipeline after it's creation
	 * @param in
	 */
	public Optional<O> get(Collection<I> in);
	

	<R> I_Pipe<I,R> map(Function<? super O, ? extends R> mapper, String name);
	
	<R> I_Pipe<I,R> map(Function<? super O, ? extends R> mapper);

	/**
	 * 
	 * @param <R>
	 * @param combiner note the accoumulator is passed in as the first argument.
	 * @return
	 */
	<R> I_Pipe<I,R> reduce(BinaryOperator<O> combiner);

	/**
	 * This is particularly useful if you can get
	 * to a steam of Integer, Floats or Doubles
	 * @param <R>
	 * @param identity
	 * @param combiner combiner note the accoumulator is passed in as the first argument.
	 * @return
	 */
	<R> I_Pipe<I,R> reduce(O identity, BinaryOperator<O> combiner);
	   
	/**
	 * 
	 * @param <R>
	 * @param identity
	 * @param accumulator
	 * @param combiner combiner note the accoumulator is passed in as the first argument.
	 * @return
	 */
	<R> I_Pipe<I,R> reduce(R identity, BiFunction<R, ? super O, R> accumulator, BinaryOperator<O> combiner);
	
	/**
	 * A terminal operation on the pipeline
	 * @param <B>
	 * @param consumer
	 * @return
	 */
	I_Run<I> then(Consumer<? super O> consumer);
	
	I_Run<I> then(Consumer<? super O> consumer, String name);
	
	<R> I_Pipe<I,R> then(Function<? super O, ? extends R> mapper);
	
	<R> I_Pipe<I,R> then(Function<? super O, ? extends R> mapper, String name);
	
	/**
	 * Binds to an ArrayList for shorter lambdas
	 * @param <R>
	 * @return
	 */
	I_Pipe<I,List<O>> toList();

	/**
	 * 
	 * @param name
	 * @return
	 */
  public I_Pipe<I, List<O>> toList(String name);
  
	/**
	 * Binds to an HashSet for shorter lambdas
	 * @param <R>
	 * @return
	*/
	I_Pipe<I,Set<O>>toSet();
	
	/**
	 * Binds to an HashSet for shorter lambdas
	 * @param <R>
	 * @return
	*/
	I_Pipe<I,Set<O>>toSet(String name);
}
