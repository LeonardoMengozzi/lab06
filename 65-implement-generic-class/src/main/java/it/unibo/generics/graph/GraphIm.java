package it.unibo.generics.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;
import it.unibo.generics.strategy.Bfs;
import it.unibo.generics.strategy.Dfs;
import it.unibo.generics.strategy.api.Strategy;

public class GraphIm<T> implements Graph<T>{
    private static final int DISCRIMINANT  = 10;

    private final Map<T, Set<T>> nodesAndEdges;

    public GraphIm() {
        this.nodesAndEdges = new HashMap<T, Set<T>>();
    }

    @Override
    public void addNode(final T node) {
        if (node != null && !nodesAndEdges.containsKey(node)) {
            this.nodesAndEdges.put(node, new HashSet<>());
        }
    }

    @Override
    public void addEdge(final T source, final T target) {
        if (source != null && target != null) {
            this.nodesAndEdges.get(source).add(target);
        }
    }

    @Override
    public Set<T> nodeSet() {
        return new HashSet<T>(Set.copyOf(this.nodesAndEdges.keySet()));
    }

    @Override
    public Set<T> linkedNodes(final T node) {
        return new HashSet<>(Set.copyOf(this.nodesAndEdges.get(node)));
    }

    @Override
    public List<T> getPath(final T source, final T target) {
        Strategy<T> str;
        if (nodeSet().size() < DISCRIMINANT) {
            str = new Bfs<>(this);
        } else {
            str = new Dfs<>(this);
        }
        return str.resolve(source, target);
    }

}
