import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Util {
    public static String getDataSetDirectoryLocation() {
        Scanner scanner = new Scanner(System.in);
        String datasetDirectoryLocation;

        while (true) {
            System.out.println("Please enter the dataset directory absolute path:");
            datasetDirectoryLocation = scanner.nextLine().trim();

            if(Files.exists(Paths.get(datasetDirectoryLocation))) break;
            System.out.println("Oops, No such directory !!\n");
        }
        return datasetDirectoryLocation;
    }

    public static String[] prepareDataset(String sourceDirectoryLocation) {
        String[] datasetFilesPath = new String[16];

        datasetFilesPath[0] = sourceDirectoryLocation + File.separator + "RAND-10000.txt";
        datasetFilesPath[1] = sourceDirectoryLocation + File.separator + "RAND-20000.txt";
        datasetFilesPath[2] = sourceDirectoryLocation + File.separator + "RAND-40000.txt";
		datasetFilesPath[3] = sourceDirectoryLocation + File.separator + "RAND-80000.txt";
		datasetFilesPath[4] = sourceDirectoryLocation + File.separator + "SORTED-10000.txt";
		datasetFilesPath[5] = sourceDirectoryLocation + File.separator + "SORTED-20000.txt";
		datasetFilesPath[6] = sourceDirectoryLocation + File.separator + "SORTED-40000.txt";
		datasetFilesPath[7] = sourceDirectoryLocation + File.separator + "SORTED-80000.txt";
		datasetFilesPath[8] = sourceDirectoryLocation + File.separator + "REVERSED-10000.txt";
		datasetFilesPath[9] = sourceDirectoryLocation + File.separator + "REVERSED-20000.txt";
		datasetFilesPath[10] = sourceDirectoryLocation + File.separator + "REVERSED-40000.txt";
		datasetFilesPath[11] = sourceDirectoryLocation + File.separator + "REVERSED-80000.txt";
		datasetFilesPath[12] = sourceDirectoryLocation + File.separator + "IDENTICAL-10000.txt";
		datasetFilesPath[13] = sourceDirectoryLocation + File.separator + "IDENTICAL-20000.txt";
		datasetFilesPath[14] = sourceDirectoryLocation + File.separator + "IDENTICAL-40000.txt";
		datasetFilesPath[15] = sourceDirectoryLocation + File.separator + "IDENTICAL-80000.txt";


        return datasetFilesPath;
    }

    public static Integer[] readDatasetIntoIntegerArray(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<Integer> dataSet = new ArrayList<>();
        String line;

        while ((line = bufferedReader.readLine()) != null)
        {
            dataSet.add(Integer.parseInt(line));
        }

        bufferedReader.close();

        return dataSet.toArray(new Integer[0]);
    }

    public static void analyzeDataset(Sorter sorter, String[] datasetFiles) {
        for (String file: datasetFiles) {
            try {
                Integer[] dataSet = Util.readDatasetIntoIntegerArray(file);

                long start = System.nanoTime();
                sorter.sort(dataSet);
                long end = System.nanoTime();

                System.out.println(dataSet.length + ",\t" + sorter.getComparisons() + ",\t" + (end - start));
                sorter.resetComparisons();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void swap(Integer[] array, int i, int j) {
        int swapTemp ;

        swapTemp  = array[i];
        array[i] = array[j];
        array[j] = swapTemp ;
    }

    static int random(int low, int high) {

        Random rand= new Random();
        return rand.nextInt(high - low) + low;
    }
}
