package com.tang.genericity;

import java.util.Set;

public interface Maps<K,V>
{
	Set<K> keySet();
	//V put<K key,V value>();
}

