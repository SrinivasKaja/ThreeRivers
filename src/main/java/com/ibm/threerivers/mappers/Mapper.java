package com.ibm.threerivers.mappers;

public interface Mapper<S, T> {
	T map(S entity);
}
