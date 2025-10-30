package it.unibo.generics.strategy;

public class DfsNode<T> extends AbsNode<T> {
    private int timeStartVisit;
    private int timeEndVisit;

    public DfsNode(T value) {
        super(value);
    }

    public int getTimeStartVisit() {
        return this.timeStartVisit;
    }
    public void setTimeStartVisit(final int timeStartVisit) {
        this.timeStartVisit = timeStartVisit;
    }
    public int getTimeEndVisit() {
        return this.timeEndVisit;
    }
    public void setTimeEndVisit(final int timeEndVisit) {
        this.timeEndVisit = timeEndVisit;
    }
}
