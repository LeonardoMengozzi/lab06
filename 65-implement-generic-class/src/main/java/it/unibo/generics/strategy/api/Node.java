package it.unibo.generics.strategy.api;

import java.util.Set;

public interface Node<T> {
    T getValue();

    int getColor();
    void setColor(int color);

    Node<T> getFather();
    void setFather(Node<T> father);

    Set<Node<T>> getAdj();
    void addAdj(Node<T> adj);
}
