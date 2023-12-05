public class InsertionSort {

    public static void main(String[] args) {
        String[] datasetFiles;
        datasetFiles = Util.prepareDataset(Util.getDataSetDirectoryLocation());

        Util.analyzeDataset(new InsertionSorter(), datasetFiles);
    }

    public static class InsertionSorter extends Sorter {

        @Override
        public void sort(Integer[] A) {
            for (int i = 1; i < A.length; i++) {
                int key = A[i];
                int j = i - 1;

                while (j >= 0) {
                    super.incrementComparisons(1);

                    if (A[j] > key) {
                        A[j + 1] = A[j];
                        j--;
                    }
                    else
                        break;
                }

                A[j + 1] = key;
            }
        }
    }
}
