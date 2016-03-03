
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

	public void traverse(int x, int y, int xH, int yH) {						//moving through the maze
		maze[y][x] = 'X';														//prints maze and current spot you are on
		print();
		if (x == xH && y == yH - 1) {											//FACING RIGHT
			if (maze[y][x + 1] == '.' || maze[y][x + 1] == 'X') {				//check if you can move forward
				traverse(x + 1, y, xH + 1, yH);
			}
			else if (maze[y][x + 1] == '#') {									//if not, check if right hand spot is open
				if (maze[yH][xH] == '.' || maze[yH][xH] == 'X') {				 
					traverse(x, y, xH - 1, yH - 1);								//if so, turn right and face down			
				}
				else if (maze[yH][xH] == '#') {									//if right hand is on wall
					traverse(x, y, xH + 1, yH - 1);								//turn left, face up
				}
			}
		}
		else if (x == xH - 1 && y == yH) {										//FACING UP
				if (maze[y - 1][x] == '.' || maze[y - 1][x] == 'X') {			//move up if possible
					traverse(x, y - 1, xH, yH - 1);
				}
				else if (maze[y - 1][x] == '#') {								//if not, check right hand spot
					if (maze[yH][xH] == '.' || maze[yH][xH] == 'X') {			
						traverse(x, y, xH - 1, yH + 1);							//if open, turn right facing right again
					}
					else if (maze[yH][xH] == '#') {								//if the right hand is not open
						traverse(x, y, xH - 1, yH - 1);							//turn left, facing left
					}
				}
		}
		else if (x == xH && y == yH + 1) {										//FACING LEFT

		}
		else if (x == xH + 1 && y == yH) {										//FACING DOWN

		}
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
