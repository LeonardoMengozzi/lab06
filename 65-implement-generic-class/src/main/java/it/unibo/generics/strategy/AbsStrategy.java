package it.unibo.generics.strategy;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;
import it.unibo.generics.strategy.api.Node;
import it.unibo.generics.strategy.api.Strategy;

public abstract class AbsStrategy<T> implements Strategy<T> {

    protected Set<Node<T>> nodes;

    protected AbsStrategy() {
        this.nodes = new HashSet<>();
    }

    protected Node<T> getNode(T source) {
        for (final var node : nodes) {
            if (node.getValue().equals(source)) {
                return node;
            }
        }
        return null;
    }

    protected List<T> resolvSolution(final Node<T> targetNode) {
        Node<T> newTargetNode = targetNode;
        List<T> solution = new LinkedList<>();
        while (newTargetNode != null) {
            solution.addFirst(newTargetNode.getValue());
            newTargetNode = newTargetNode.getFather();
        }
        return solution;
    }

    protected abstract void initNode(Graph<T> grp);
}
