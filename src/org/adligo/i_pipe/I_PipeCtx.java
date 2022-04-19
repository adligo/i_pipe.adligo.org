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
public interface I_PipeCtx {

  /**
   * Create a new Pipe providing the initial consumer
   * @param <I> the input
   * @param consumer
   * @return
   */
  <I> I_Pipe<I, Void> newPipe(Consumer<I> consumer);

  /**
   * Create a new Pipe providing the initial consumer
   * @param <I> the input
   * @param consumer
   * @return
   */
  <I> I_Pipe<I, Void> newPipe(Consumer<I> consumer, String name);

  /**
   * Create a new Pipe providing the initial consumer
   * @param <I> the input
   * @param <R> the return from the function fun
   * @param <O> the output
   * @param consumer
   * @return
   */
  <I, O> I_Pipe<I, O> newPipe(Function<I, O> fun);

  /**
   * Create a new Pipe providing the initial consumer
   * @param <I> the input
   * @param <R> the return from the function fun
   * @param <O> the output
   * @param consumer
   * @return
   */
  <I, O> I_Pipe<I, O> newPipe(Function<I, O> fun, String name);

}
