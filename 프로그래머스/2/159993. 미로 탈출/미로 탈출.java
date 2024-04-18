import java.util.*;

class Solution {
    static Character[][] maze;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public int solution(String[] maps) {
        maze = new Character[maps.length][maps[0].length()];
        int[] start = new int[2];
        int[] lever = new int[2];
        
        for (int i = 0; i < maps.length; i++) {
            String line = maps[i];
            for (int j = 0; j < line.length(); j++) {
                maze[i][j] = line.charAt(j);
                
                if (maze[i][j] == 'S') {
                    start = new int[]{i, j};
                } else if (maze[i][j] == 'L') {
                    lever = new int[]{i, j};
                }
            }
        }
        
        int result1 = bfs(start, 'L');
        if (result1 == -1)
            return -1;
        
        int result2 = bfs(lever, 'E');
        if (result2 == -1)
            return -1;
        
        return result1 + result2;
    }
    
    public int bfs(int[] start, Character target) {
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        
        queue.add(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;
        
        while (!queue.isEmpty()) {
            int row = queue.peek()[0];
            int col = queue.peek()[1];
            int count = queue.peek()[2];
            
            if (maze[row][col] == target) {
                return count;
            }
            queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nextRow = row + dir[i][0];
                int nextCol = col + dir[i][1];
                
                if (nextRow < 0 || nextCol < 0 || nextRow >= maze.length || nextCol >= maze[0].length || visited[nextRow][nextCol]) {
                    continue;
                } else if (maze[nextRow][nextCol] == 'X') {
                    continue;
                } else {
                    visited[nextRow][nextCol] = true;
                    queue.add(new int[]{nextRow, nextCol, count + 1});
                }
            }
        }
        
        
        return -1;
    }
}