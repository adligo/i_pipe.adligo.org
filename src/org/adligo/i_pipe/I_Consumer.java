package org.adligo.i_pipe;

import java.util.Collection;

/**
 * Something that consumes or accepts input.
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
public interface I_Consumer<I> {

  /**
   * Run the pipeline after it's creation
   * 
   * @param in
   */
  public void accept(I in);

  /**
   * Run the pipeline after it's creation
   * 
   * @param in
   */
  public void accept(@SuppressWarnings("unchecked") I... in);
  
  /**
   * Run the pipeline after it's creation
   * 
   * @param in
   */
  public void accept(Collection<I> in);
}
