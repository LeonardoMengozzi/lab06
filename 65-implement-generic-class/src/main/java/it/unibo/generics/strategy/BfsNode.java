package it.unibo.generics.strategy;

public class BfsNode<T> extends AbsNode<T> {
    private int distance;

    public BfsNode(T value) {
        super(value);
        this.distance = Integer.MAX_VALUE;
    }

    public int getDistance() {
        return this.distance;
    }
    public void setDistance(final int distance) {
        this.distance = distance;
    }
}
