public class RandomizedQuickSort{

    public static void main(String[] args) {
        String[] datasetFiles;
        datasetFiles = Util.prepareDataset(Util.getDataSetDirectoryLocation());

        Util.analyzeDataset(new RandomizedQuickSorter(), datasetFiles);
    }

    public static class RandomizedQuickSorter extends Sorter {

        @Override
        public void sort(Integer[] A) {
            quickSort(A, 0, A.length-1);
        }

        private void quickSort(Integer[] A, int p, int r)
        {
            /*
             * The simple implementation of QuickSort makes two recursive calls,
             * so it will throw StackOverflowError for large lists.
            if (p < r)
            {
                int q = randomizedPartition(A, p, r);
                quickSort(A, p, q-1);
                quickSort(A, q+1, r);
            }
            */


            /*
             * This implementation of QuickSort will optimize QuickSort Tail Call and Stack depth.
             * It requires O(Log n) auxiliary space in worst case.
             */
            while (p < r)
            {
                int q = randomizedPartition(A, p, r);

                if (q - p < r - q)
                {
                    quickSort(A, p, q - 1);
                    p = q + 1;
                }

                else
                {
                    quickSort(A, q + 1, r);
                    r = q - 1;
                }
            }
        }

        private int randomizedPartition(Integer[] A, int p, int r)
        {
            int i = Util.random(p, r);
            Util.swap(A, i, r);

            return partition(A, p, r);
        }

        private int partition(Integer[] A, int p, int r)
        {
            /*
             * The implementation below selects the first element of array as the pivot element.
             */
            int x = A[p];
            int i = p + 1;

            for (int j = p + 1; j <= r; j++){
                super.incrementComparisons(1);

                if (A[j] <= x)
                    Util.swap(A, i++, j);
            }

            Util.swap(A, p, i - 1);
            return i - 1;
        }
    }
}
