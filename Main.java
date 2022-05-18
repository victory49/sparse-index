import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

class Main {
    public static void main(String[] args) {
        SparseIndex array = new SparseIndex();

        try {
            List<String> lines = Files.readAllLines(Paths.get("./random_numbers.txt"));
            for (String line : lines) {
                array.insert(Integer.parseInt(line));
            }
        } catch (IOException e) {
            // e.printStackTrace();
        }

        array.insert(216);
        array.insert(217);

        array.lookup(216);

        array.delete(216);

        array.lookup(217);
    }
}