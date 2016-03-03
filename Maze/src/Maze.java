
public class Maze {
	char maze[][] = {{'#','#','#','#','#','#','#','#','#','#','#','#'},
			{'#','.','.','.','#','.','.','.','.','.','.','#'},
			{'.','.','#','.','#','.','#','#','#','#','.','#'},
			{'#','#','#','.','#','.','.','.','.','#','.','#'},
			{'#','.','.','.','.','#','#','#','.','#','.','#'},
			{'#','#','#','#','.','#','F','#','.','#','.','#'},
			{'#','.','.','#','.','#','.','#','.','#','.','#'},
			{'#','#','.','#','.','#','.','#','.','#','.','#'},
			{'#','.','.','.','.','.','.','.','.','#','.','#'},
			{'#','#','#','#','#','#','.','#','#','#','.','#'},
			{'#','.','.','.','.','.','.','#','.','.','.','#'},
			{'#','#','#','#','#','#','#','#','#','#','#','#'}};
	public Maze() {
		print();
	}
	
	public void traverse(int x, int y, int xH, int yH) {
		maze[y][x] = 'X';
		print();
		if (maze[y][x + 1] == '.' || maze[y][x + 1] == 'X') {
			traverse(x + 1, y, xH + 1, yH);
		}
		else if (maze[y][x + 1] == '#') {
			if (maze[yH][xH] == '.' || maze[yH][xH] == 'X') {
				traverse(x, y + 1, xH - 1, yH);
			}
			else if (maze[yH][xH] == '#') {
				if (maze[y - 1][x] == '.' || maze[y - 1][x] == 'X') {
					traverse(x, y - 1, xH + 1, yH - 2);
				}
				else System.out.println("Got stuck at " + x + ", " + y);
			}
			else System.out.println("Got stuck at " + x + ", " + y);
		}
		else if (maze[y + 1][x] == '.' || maze[y + 1][x] == 'X') {
			traverse(x, y + 1, xH, yH + 1);
		}
		else System.out.println("Got stuck at " + x + ", " + y);
	}
	
	public void read() {
		
	}
	
	public void print() {
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++) {
				System.out.print(maze[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
