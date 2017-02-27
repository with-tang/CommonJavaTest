package com.tang.genericity;
public interface Lists<E>
{
	void add(E x);
	Iterators<E> iterator();
}