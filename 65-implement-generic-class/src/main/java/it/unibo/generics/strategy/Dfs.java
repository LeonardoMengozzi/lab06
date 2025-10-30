package it.unibo.generics.strategy;

import java.util.List;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;

public class Dfs<T> extends AbsStrategy<T> {

    private int time;

    public Dfs(final Graph<T> grp) {
        super();
        initNode(grp);
    }

    @Override
    protected void initNode(Graph<T> grp) {
        for (final var node: grp.nodeSet()) {
            this.nodes.add(new DfsNode<T>(node));
        }
        for (final var nodeChecking: this.nodes) {
            Set<T> adjNodes = grp.linkedNodes(nodeChecking.getValue());
            for (final var otherNode: this.nodes) {
                if (adjNodes.contains(otherNode.getValue())) {
                    nodeChecking.addAdj(otherNode);
                }
            }
        }    
    }

    @Override
    public List<T> resolve(T source, T target) {
        dfs((DfsNode<T>)getNode(source));
        return resolvSolution(getNode(target));
    }

    private void dfs(final DfsNode<T> nodeSource) {
        nodeSource.setColor(AbsNode.GRAY);
        time ++; 
        nodeSource.setTimeStartVisit(time);
        for (var adjNode : nodeSource.getAdj()) {
            var adjDfsNode = (DfsNode<T>)adjNode;
            if (adjDfsNode.getColor() == AbsNode.WHITE) {
                adjDfsNode.setFather(nodeSource);
                dfs(adjDfsNode);
            }
        }
        nodeSource.setColor(AbsNode.BLACK);
        time++;
        nodeSource.setTimeEndVisit(time);
    }

}