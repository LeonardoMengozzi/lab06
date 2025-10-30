package it.unibo.generics.strategy;

import java.util.HashSet;
import java.util.Set;

import it.unibo.generics.strategy.api.Node;

public abstract class AbsNode<T> implements Node<T> {
    public static final int WHITE = 0;
    public static final int GRAY = 1;
    public static final int BLACK = 2;

    private final T value;
    private int color;
    private Node<T> father;
    private Set<Node<T>> adj;

    public AbsNode(final T value) {
        this.value = value;
        this.color = WHITE;
        this.adj = new HashSet<Node<T>>();
    }

    public T getValue() {
        return this.value;
    }

    public int getColor() {
        return this.color;
    }
    public void setColor(final int color) {
        this.color = color;
    }

    public Node<T> getFather() {
        return this.father;
    }
    public void setFather(final Node<T> father) {
        this.father = father;
    }

    public Set<Node<T>> getAdj() {
        return new HashSet<Node<T>>(Set.copyOf(this.adj));
    }
    public void addAdj(Node<T> adj) {
        this.adj.add(adj);
    }
}
