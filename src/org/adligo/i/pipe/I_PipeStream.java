package org.adligo.i.pipe;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public interface I_PipeStream<T> {

//	
//	<R> I_Pipe<R> flatMap(Function<? super T, ? extends I_Pipe<? extends R>> mapper);
//
//	IntStream flatMapToInt(Function<? super T, ? extends IntStream> mapper);
//
//	LongStream flatMapToLong(Function<? super T, ? extends LongStream> mapper);
//
//	DoubleStream flatMapToDouble(Function<? super T, ? extends DoubleStream> mapper);
//	
//	Iterator<T> iterator();
//
//	boolean isParallel();
//	
//	I_Pipe<T> limit(long maxSize);
//	
//	
//
//	IntStream mapToInt(ToIntFunction<? super T> mapper) ;
//
//	LongStream mapToLong(ToLongFunction<? super T> mapper);
//	
//	DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper);
//
//	I_Pipe<T> onClose(Runnable closeHandler);
//	
//	I_Pipe<T> peek(Consumer<? super T> action);
//	
//	I_Pipe<T> parallel();
//	
//	Spliterator<T> spliterator();
//
//	I_Pipe<T> sequential();
//
//	I_Pipe<T> sorted();
//
//	I_Pipe<T> sorted(Comparator<? super T> comparator);
//
//	I_Pipe<T> skip(long n);
//	
//	void then(Consumer<? super T> consumer) ;
//
//	<R> I_Pipe<R> then(Function<? super T, ? extends R>  fun) ;
//	
//	I_Pipe<T> unordered();
}
