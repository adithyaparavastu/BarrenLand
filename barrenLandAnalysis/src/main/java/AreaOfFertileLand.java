import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 * Created by adithya_paravastu on 1/10/18.
 */

public class AreaOfFertileLand {

    // It will replace , [ ] with blank space
    public String printOutput(String[] input){
        AreaOfFertileLand gm = new AreaOfFertileLand();
        String res = (Arrays.toString(gm.sortedAreas(input)));
        res = res.replace(",", "").replace("[", "").replace("]", "");
        return res;
    }

    // Co-ordinates of the rectangle from the barren land.
    int row1, row2, col1, col2;

    //Given Coordinates for the farm 400mx600m
    private static int rows = 400;
    private static int columns = 600;

    private int[][] barrenLand;

    public AreaOfFertileLand() {
        barrenLand = new int[rows][columns];
    }

        private class Node {
        private int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    // Calculate the total Number of cells in the matrix with 0.
    protected int getNumOfCells(int row, int col) {

        int count = 0;
        Stack<Node> stack = new Stack<Node>();
        stack.push(new Node(row, col));

        while (!stack.isEmpty()) {

            Node node = stack.pop();
            int r = node.r;
            int c = node.c;

            if (r < 0 || r >= rows) continue;
            if (c < 0 || c >= columns) continue;
            if (barrenLand[r][c] != 0) continue;

            barrenLand[r][c] = 1;   // Change the value of the visited node to 1.
            count++;

            // it checks whether the adjacent nodes are Zero or not

            stack.push(new Node(r - 1, c)); stack.push(new Node(r, c + 1));
            stack.push(new Node(r + 1, c)); stack.push(new Node(r, c - 1));
        }
        return count; // returns the number of cells in one block.
    }

    public int[] sortedAreas(String[] input) {

        // Initialize a Array with zero
        for (int r = 0; r < rows; r++)
            Arrays.fill(barrenLand[r], 0); // initially it fills all the cells in the farm with 0

        // Color the coordinates from the input to 1.

        // Reading the co-ordinates from the input
        for (String rectangle : input) {
            String[] coordinates = rectangle.split(" ");
            row1 = Integer.parseInt(coordinates[0]); col1 = Integer.parseInt(coordinates[1]);
            row2 = Integer.parseInt(coordinates[2]); col2 = Integer.parseInt(coordinates[3]);
            // Mark all the blocked area with 1.
            for (int r = row1; r <= row2; r++)
                for (int c = col1; c <= col2; c++)
                    barrenLand[r][c] = 1;  // Coloring the co-ordinates to 1
        }

        // Adding all the cells with 0 in the Adjacency matrix to an Arraylist
        ArrayList<Integer> fertileLand = new ArrayList<Integer>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                if (barrenLand[r][c] == 0) {
                    fertileLand.add(getNumOfCells(r, c));
                }
            }
        }

        // sort the area of fertile land from smallest to greatest by area
        Collections.sort(fertileLand);
        int[] sorted = new int[fertileLand.size()];
        for (int i = 0; i < sorted.length; i++){
            sorted[i] = fertileLand.get(i);}

        return sorted;
    }

}
