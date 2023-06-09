
public class DSAJava {
    public static void main(String[] args) {
        int[][] input = { { 1, 1, 0, 1, 1 },
                { 1, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1 },
                { 1, 1, 0, 1, 1 } };

        NumberOfDistinctIcelands obj = new NumberOfDistinctIcelands();
        int count = obj.countDistinctIslands(input);
        System.out.println(count);
    }
}
