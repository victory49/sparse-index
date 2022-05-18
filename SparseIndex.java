import java.util.ArrayList;
import java.util.HashMap;

public class SparseIndex {
    private HashMap<Integer, HashMap<Integer, ArrayList<Integer>>> data = new HashMap<Integer, HashMap<Integer, ArrayList<Integer>>>();

    public boolean insert(int row) {
        System.out.printf("Inserting %d...\n", row);
        int key1 = (row / 100) * 100;
        if (!data.containsKey(key1))
            data.put(key1, new HashMap<Integer, ArrayList<Integer>>());
        System.out.printf("\tLookup index1: %d\n", key1);
        HashMap<Integer, ArrayList<Integer>> index1 = data.get(key1);
        int key2 = (row / 10) * 10;
        if (!index1.containsKey(key2))
            index1.put(key2, new ArrayList<Integer>());
        System.out.printf("\tLookup index2: %d\n", key2);
        ArrayList<Integer> index2 = index1.get(key2);
        if (index2.contains(row)) {
            System.out.println("\tAlready exists.");
            return false;
        }
        index2.add(row);
        System.out.printf("\tInsert record: %d at %d\n", row, index2.indexOf(row));
        return true;
    }

    public boolean delete(int row) {
        System.out.printf("Deleting %d...\n", row);
        int key1 = (row / 100) * 100;
        if (!data.containsKey(key1)) {
            System.out.println("\tIndex1 does not exist.");
            return false;
        }
        System.out.printf("\tLookup index1: %d\n", key1);
        int key2 = (row / 10) * 10;
        HashMap<Integer, ArrayList<Integer>> index1 = data.get(key1);
        if (!index1.containsKey(key2)) {
            System.out.println("\tIndex2 does not exist.");
            return false;
        }
        System.out.printf("\tLookup index2: %d\n", key2);
        ArrayList<Integer> index2 = index1.get(key2);
        if (!index2.contains(row)) {
            System.out.println("\tNo record exists.");
            return false;
        }
        System.out.printf("\tDelete record: %d at %d\n", row, index2.indexOf(row));
        index2.remove(new Integer(row));
        return true;
    }

    public boolean lookup(int row) {
        System.out.printf("Looking %d up...\n", row);
        int key1 = (row / 100) * 100;
        if (!data.containsKey(key1)) {
            System.out.println("\tIndex1 does not exist.");
            return false;
        }
        System.out.printf("\tLookup index1: %d\n", key1);
        int key2 = (row / 10) * 10;
        HashMap<Integer, ArrayList<Integer>> index1 = data.get(key1);
        if (!index1.containsKey(key2)) {
            System.out.println("\tIndex2 does not exist.");
            return false;
        }
        System.out.printf("\tLookup index2: %d\n", key2);
        ArrayList<Integer> index2 = index1.get(key2);
        if (!index2.contains(row)) {
            System.out.printf("\tNo record exists(%d).\n", row);
            return false;
        }
        System.out.printf("\tLookup record: %d at %d\n", row, index2.indexOf(row));
        return true;
    }
}
