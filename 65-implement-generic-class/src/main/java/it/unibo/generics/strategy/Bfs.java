package it.unibo.generics.strategy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;

public class Bfs<T> extends AbsStrategy<T> {
    private final static int SOURCE_START_DISTANCE = 0;    

    public Bfs(final Graph<T> grp) {
        super();
        initNode(grp);
    }

    @Override
    protected void initNode(final Graph<T> grp) {
        for (final var node: grp.nodeSet()) {
            this.nodes.add(new BfsNode<T>(node));
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
    public List<T> resolve(final T source, final T target) {
        bfs((BfsNode<T>)getNode(source));
        return resolvSolution(getNode(target));
    }

    private void bfs(final BfsNode<T> nodeSource) {
        nodeSource.setColor(AbsNode.GRAY);
        nodeSource.setDistance(SOURCE_START_DISTANCE);
        Queue<BfsNode<T>> q = new LinkedList<BfsNode<T>>();
        q.offer(nodeSource);
        while (!q.isEmpty()) {
            BfsNode<T> node = q.peek();
            for (var adjNode : node.getAdj()) {
                var adjBfsNode = (BfsNode<T>)adjNode;
                if (adjBfsNode.getColor() == AbsNode.WHITE) {
                    adjBfsNode.setColor(AbsNode.GRAY);
                    adjBfsNode.setDistance(adjBfsNode.getDistance() + 1);
                    adjBfsNode.setFather(node);
                    q.offer(adjBfsNode);
                }
            }
            q.poll();
            node.setColor(AbsNode.BLACK);
        }
    }

}
