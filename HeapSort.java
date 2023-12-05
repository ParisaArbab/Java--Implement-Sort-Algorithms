public class HeapSort {

    public static void main(String[] args) {
        String[] dataset;
        dataset = Util.prepareDataset(Util.getDataSetDirectoryLocation());

        Util.analyzeDataset(new HeapSorter(), dataset);
    }

    public static class HeapSorter extends Sorter {

        @Override
        public void sort(Integer[] A) {
            int heapSize = A.length - 1;
            buildMaxHeap(A);
            for (int i = A.length - 1; i > 0; i--) {
                Util.swap(A, 0, i);
                heapSize--;
                maxHeapify(A, 0, heapSize);
            }
        }

        private void buildMaxHeap(Integer[] A) {
            int heapSize = A.length - 1;
            for (int i = heapSize / 2; i >= 0; i--) {
                maxHeapify(A, i, heapSize);
            }
        }

        private void maxHeapify(Integer[] A, int i, int heapSize) {
            int L = leftChild(i);
            int R = rightChild(i);
            int largest = i;

            if (L <= heapSize) {
                super.incrementComparisons(1);

                if (A[L] > A[i])
                    largest = L;
            }

            if (R <= heapSize) {
                super.incrementComparisons(1);

                if (A[R] > A[largest])
                    largest = R;
            }

            if (largest != i) {
                Util.swap(A, i, largest);
                maxHeapify(A, largest, heapSize);
            }
        }

        private int leftChild(int i) {
            return 2 * i + 1;
        }

        private int rightChild(int i) {
            return 2 * i + 2;
        }
    }
}
