package it.unibo.generics.strategy.api;

import java.util.List;

public interface Strategy<T> {
    List<T> resolve(T source, T target);
}
