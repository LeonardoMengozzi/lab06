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
    private static final int MIN = 1000;
    private static final int MAX = 2000;
    private static final int ELEMS = 100_000;
    private static final int ELEMS_TO_READ = 1_000;

    private UseListsAndMaps() {
    }

    private static String formatTime(final long time) {
        final var millis = TimeUnit.NANOSECONDS.toMillis(time);
        return time + "ns (" + millis + "ms)";
    }

    private static long timeHeadInserction(final List<Integer> lst, final int elem) {
        final long time = System.nanoTime();
        for (int i = 0; i < elem; i++) {
            lst.addFirst(i);
        }
        return System.nanoTime() - time;
    }

    private static long timeReadingByMiddle(final List<Integer> lst, final int elem) {
        final int idxStart = lst.size() / 2;
        final long time = System.nanoTime();
        for (int i = 0; i < elem; i++) {
            lst.get(idxStart + i);
        }
        return System.nanoTime() - time;
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
        List<Integer> arrLst = new ArrayList<>();
        for (int i = MIN; i < MAX; i++) {
            arrLst.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        List<Integer> lnkLst = new LinkedList<>(arrLst);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        final int last = arrLst.size() - 1;
        final int temp = arrLst.get(arrLst.size() - arrLst.size());
        arrLst.set(arrLst.size() - arrLst.size(), arrLst.get(last));
        arrLst.set(last, temp);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (Integer i : arrLst) {
            System.err.println(i);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time;
        time = timeHeadInserction(arrLst, ELEMS);
        System.out.println("Tempo inserimento ArrayList: " + formatTime(time));
        time = timeHeadInserction(lnkLst, ELEMS);
        System.out.println("Tempo inserimento LinkedList: " + formatTime(time));
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        time = timeReadingByMiddle(arrLst, ELEMS_TO_READ);
        System.out.println("Tempo lettura ArrayList: " + formatTime(time));
        time = timeReadingByMiddle(lnkLst, ELEMS_TO_READ);
        System.out.println("Tempo lettura LinkedList: " + formatTime(time));
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
        long sum = 0;
        for(var elem : continesAndNAmes.values()) {
            sum += elem;
        }
        System.out.println("Popolazione Totale: " + sum);
    }
}
