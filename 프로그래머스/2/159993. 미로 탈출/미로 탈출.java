import java.util.*;

class Solution {
    static Character[][] maze;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public int solution(String[] maps) {
        
        maze = new Character[maps.length][maps[0].length()];
        int[][] visited = new int[maps.length][maps[0].length()];
        int startRow = 0, startCol = 0;
        int leverRow = 0, leverCol = 0;
        
        for (int i = 0; i < maps.length; i++) {
            String line = maps[i];
            for (int j = 0; j < line.length(); j++) {
                maze[i][j] = line.charAt(j);
                
                if (line.charAt(j) == 'S') {
                    startRow = i;
                    startCol = j;
                } else if (line.charAt(j) == 'L') {
                    leverRow = i;
                    leverCol = j;
                }
            }
        }
        
        // bfs 탐색을 한다.
        int result1 = bfs(startRow, startCol, 'L');        
        if (result1 == -999)
            return -1;
        
        int result2 = bfs(leverRow, leverCol, 'E');
        if (result2 == -999)
            return -1;
            
        return result1 + result2;
    }
    
    public int bfs(int startRow, int startCol, Character target) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startRow, startCol, 0});
        
        boolean[][] isVisited = new boolean[maze.length][maze[0].length];
        isVisited[startRow][startCol] = true;
        
        while (!queue.isEmpty()) {
            int row = queue.peek()[0];
            int col = queue.peek()[1];
            int count = queue.peek()[2];
            
            // 탐색 성공
            if (maze[row][col] == target) {
                return count;
            }
            queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nextRow = row + dir[i][0];
                int nextCol = col + dir[i][1];
                
                if (nextRow < 0 || nextCol < 0 || nextRow >= maze.length || nextCol >= maze[0].length || isVisited[nextRow][nextCol]) {
                    continue;
                } else if (maze[nextRow][nextCol] == 'X') {
                    continue;
                } else {
                    isVisited[nextRow][nextCol] = true;
                    queue.add(new int[]{nextRow, nextCol, count + 1});
                }
            }
        }
        // 탐색 실패
        return -999;
    }
}