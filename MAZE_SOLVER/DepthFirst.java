import java.util.*;

//This class contains logic of path from the starting point to the destination.
public class DepthFirst {
    public static boolean searchPath(int maze[][],int x,int y,ArrayList<Integer>path) {
        if (maze[y][x] == 9) {
            path.add(x);
            path.add(y);
            return true;
        }

        if (maze[y][x] == 0) {
            //mark it as visited
            maze[y][x] = 2;

            int dx[] = new int[]{-1, 0, 1, 0};
            int dy[] = new int[]{0, 1, 0, -1};

            for (int i = 0; i < 4; i++) {
                int new_x = x + dx[i];
                int new_y = y + dy[i];

                if (searchPath(maze, new_x, new_y, path)) {
                    path.add(new_x);
                    path.add(new_y);
                    return true;
                }
            }
        }
        return false;
    }
}
