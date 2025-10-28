package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {
    private static final int ELEMS = 100_000;
    private static final int ELEMS_TO_READ = 1_000;

    private UseListsAndMaps() {
    }

    private static void printTime(final long time) {
        final var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(time + "ns (" + millis + "ms)");
    }

    private static void calcInserctionTime(final List<Integer> li) {
        long time = System.nanoTime();
        for (int i = 0; i < ELEMS; i++) {
            li.addFirst(i);
        }
        time = System.nanoTime() - time;
        printTime(time);
    }

    private static void calcReadingTime(final List<Integer> li, final int posStartReading) {
        long time = System.nanoTime();
        for (int i = posStartReading; i < ELEMS_TO_READ; i++) {
            li.get(i);
        }
        time = System.nanoTime() - time;
        printTime(time);
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        final int min = 1000;
        final int max = 2000;
        List<Integer> li = new ArrayList<>();
        for (int i = min; i < max; i++) {
            li.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        List<Integer> li2 = new LinkedList<>(li);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        final int last = li.size() - 1;
        final int temp = li.get(li.size() - li.size());
        li.set(li.size() - li.size(), li.get(last));
        li.set(last, temp);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (Integer i : li2) {
            System.err.println(i);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        calcInserctionTime(li);
        calcInserctionTime(li2);
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        calcReadingTime(li, 5);
        calcReadingTime(li2, 5);
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        Map<String, Long> continesAndNAmes = new HashMap<>(Map.of(
            "Africa", 1_110_635_000L,
            "Americas", 972_005_000L,
            "Antarctica", 0L,
            "Asia", 4_298_723_000L,
            "Europe", 742_452_000L,
            "Oceania", 38_304_000L
        ));
        /*
         * 8) Compute the population of the world
         */
        System.out.println(continesAndNAmes);
    }
}
