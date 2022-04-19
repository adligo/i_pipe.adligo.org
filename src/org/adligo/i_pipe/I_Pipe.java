package org.adligo.i_pipe;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Note that I_Pipe is almost identical to a java.util.stream.Stream the main
 * difference is that it MAY be executed (supplied) at a later time and also
 * mimics a list of steps with the then method.
 * 
 * Known Implementations {@link org.adligo.pipe.PipeCtx}
 * 
 * @author scott
 *
 * @param <I> input
 * @param <O> output
 * @author scott<br/><br/>
 *
 * <pre><code>
 *  ---------------- Apache ICENSE-2.0 --------------------------
 *
 * Copyright 2022 Adligo Inc
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *    http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </code></pre>
 */
public interface I_Pipe<I, O> extends I_Consumer<I> {

  /**
   * Block the input from continuing through the chain.
   * The opposite of the filter method.
   * @param predicate if the predicate returns true block this input from proceeding 
   * @return
   */
  I_Pipe<I, O> block(Predicate<? super O> predicate);

  /**
   * Block the input from continuing through the chain.
   * The opposite of the filter method.
   * @param predicate if the predicate returns true block this input from proceeding 
   * down the pipe.
   * @param name
   * @return
   */
  I_Pipe<I, O> block(Predicate<? super O> predicate, String name);
  
  /**
   * a sink that provides distinct elements only
   * @return
   */
  I_Pipe<I, O> distinct();

  /**
   * a sink that provides distinct elements only
   * @return
   */
  I_Pipe<I, O> distinct(String name);

  /**
   * a sink that provides distinct elements only
   * @param distinguisher a interface that distinguishes between identical stream elements
   * @return
   */
  I_Pipe<I, O> distinct(I_Distinguisher<I> distinguisher);

  /**
   * a sink that provides distinct elements only
   * @param distinguisher a interface that distinguishes between identical stream elements
   * @return
   */
  I_Pipe<I, O> distinct(I_Distinguisher<I> distinguisher, String name);
  
  /**
   * The opposite of block
   * @param predicate if it returns true the input is passed to the next section
   * of the pipe.
   * @return
   */
  I_Pipe<I, O> filter(Predicate<? super O> predicate);

  /**
   * The opposite of block
   * @param predicate if it returns true the input is passed to the next section
   * of the pipe.
   * @param name
   * @return
   */
  I_Pipe<I, O> filter(Predicate<? super O> predicate, String name);

  /**
   * A fork in the road (aka a choice or decision) A terminal operation
   * 
   * @param <B>
   * @param <R>
   * @param consumer
   * @return
   */
  I_Consumer<I> fork(Consumer<? super O> consumer);

  /**
   * A fork in the road (aka a choice or decision) A terminal operation
   * 
   * @param consumer
   * @param name
   * @return
   */
  I_Consumer<I> fork(Consumer<? super O> consumer, String name);

  /**
   * A fork in the road (aka a choice or decision) A terminal operation
   * 
   * @param <B>
   * @param <R>
   * @param mapper
   * @return
   */
  <B, R> I_Pipe<I, R> fork(Function<? super O, ? extends R> mapper);

  /**
   * A fork in the road (aka a choice or decision) A terminal operation
   * 
   * @param <B>
   * @param <R>
   * @param mapper
   * @param name
   * @return
   */
  <B, R> I_Pipe<I, R> fork(Function<? super O, ? extends R> mapper, String name);

  <R> I_Pipe<I, R> map(Function<? super O, ? extends R> mapper, String name);

  <R> I_Pipe<I, R> map(Function<? super O, ? extends R> mapper);

  /**
   * 
   * @param <R>
   * @param combiner note the accoumulator is passed in as the first argument.
   * @return
   */
  <R> I_Pipe<I, R> reduce(BinaryOperator<O> combiner);

  /**
   * This is particularly useful if you can get to a steam of Integer, Floats or
   * Doubles
   * 
   * @param <R>
   * @param identity
   * @param combiner combiner note the accoumulator is passed in as the first
   *                 argument.
   * @return
   */
  <R> I_Pipe<I, R> reduce(O identity, BinaryOperator<O> combiner);

  /**
   * 
   * @param <R>
   * @param identity
   * @param accumulator
   * @param combiner    combiner note the accoumulator is passed in as the first
   *                    argument.
   * @return
   */
  <R> I_Pipe<I, R> reduce(R identity, BiFunction<R, ? super O, R> accumulator, BinaryOperator<O> combiner);


  /**
   * Run the pipeline after it's creation
   * 
   * @param in
   */
  public Optional<O> supply(I in);

  /**
   * Run the pipeline after it's creation
   * 
   * @param in
   */
  public Optional<O> supply(@SuppressWarnings("unchecked") I... in);

  /**
   * Run the pipeline after it's creation
   * 
   * @param in
   */
  public Optional<O> supply(Collection<I> in);
  
  /**
   * A terminal operation on the pipeline
   * 
   * @param <B>
   * @param consumer
   * @return
   */
  I_Consumer<I> then(Consumer<? super O> consumer);

  I_Consumer<I> then(Consumer<? super O> consumer, String name);

  <R> I_Pipe<I, R> then(Function<? super O, ? extends R> mapper);

  <R> I_Pipe<I, R> then(Function<? super O, ? extends R> mapper, String name);

  /**
   * 
   * @param name
   * @return
   */
  List<O> toCollection(Supplier<Collection<O>> collectionSupplier);

  /**
   * 
   * @param name
   * @return
   */
  List<O> toCollection(Supplier<Collection<O>> collectionSupplier, String name);
  
  /**
   * Binds to an ArrayList for shorter lambdas
   * 
   * @param <R>
   * @return
   */
  List<O> toList();

  /**
   * 
   * @param name
   * @return
   */
   List<O> toList(String name);

  /**
   * 
   * @param name
   * @return
   */
  List<O> toList(Supplier<List<O>> listSupplier);

  /**
   * 
   * @param name
   * @return
   */
  List<O> toList(Supplier<List<O>> listSupplier, String name);
  
  /**
   * Binds to an HashSet for shorter lambdas
   * 
   * @param <R>
   * @return
   */
  <K,V> Map<K, V> toMap(BiConsumer<O, Map<K,V>> collector);

  /**
   * Binds to an HashSet for shorter lambdas
   * 
   * @param <R>
   * @return
   */
  <K,V> Map<K, V> toMap(String name, BiConsumer<O, Map<K,V>> collector);
  
  /**
   * Binds to an HashSet for shorter lambdas
   * 
   * @param <R>
   * @return
   */
  <K,V> Map<K, V> toMap(Supplier<Map<K, V>> setSupplier, BiConsumer<O, Map<K,V>> collector);

  /**
   * Binds to an HashSet for shorter lambdas
   * 
   * @param <R>
   * @return
   */
  <K, V> Map<K, V> toMap(Supplier<Map<K, V>> setSupplier, String name, BiConsumer<O, Map<K,V>> collector);
  
  /**
   * Binds to an HashSet for shorter lambdas
   * 
   * @param <R>
   * @return
   */
  Set<O> toSet();

  /**
   * Binds to an HashSet for shorter lambdas
   * 
   * @param <R>
   * @return
   */
  Set<O> toSet(String name);
  
  /**
   * Binds to an HashSet for shorter lambdas
   * 
   * @param <R>
   * @return
   */
  Set<O> toSet(Supplier<Set<O>> setSupplier);

  /**
   * Binds to an HashSet for shorter lambdas
   * 
   * @param <R>
   * @return
   */
  Set<O> toSet(Supplier<Set<O>> setSupplier, String name);
}
