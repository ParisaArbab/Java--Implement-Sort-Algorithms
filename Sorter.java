public abstract class Sorter {
    public long comparisons = 0;

    public abstract void sort(Integer[] array);

    public void resetComparisons() {
        comparisons = 0;
    }

    public void incrementComparisons(long value) {
        comparisons += value;
    }

    public long getComparisons() {
        return comparisons;
    }
}
