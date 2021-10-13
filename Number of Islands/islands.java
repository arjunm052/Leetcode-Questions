public class islands {
    public static void main(String[] args) {

    }

    public int numIslands(char[][] grid) {
        // visited array marks all the nodes that have been visited
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        // final result
        int result = 0;

        // Traverse all the nodes
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // if the node is a islands and it hasn't been visited yet then increase the
                // result and explore all the land pieces connected to it
                if (grid[i][j] == '1' && visited[i][j] == false) {
                    findIslands(grid, i, j, visited);
                    result++;
                }
            }
        }
        // return the final result
        return result;
    }

    public static void findIslands(char[][] grid, int i, int j, boolean[][] visited) {
        // base case - check if we inside matrix, current node is a land and it hasn't
        // been visited yet else return
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0' || visited[i][j]) {
            return;
        }

        // mark current land as visited and explore all the lands in all four directions
        visited[i][j] = true;
        findIslands(grid, i - 1, j, visited);
        findIslands(grid, i, j + 1, visited);
        findIslands(grid, i, j - 1, visited);
        findIslands(grid, i + 1, j, visited);

    }
}
