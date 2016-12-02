package annaDanielBejeweled;
 
public class DanielBackend {
	public static String[][] swap(String[][] grid,int r, int c,String d){
		if(d.equals("w")){
			String temp = grid[r-1][c] ;
			grid[r-1][c] = grid[r][c];
			grid[r][c] = temp;
		}else{
			if(d.equals("a")){
				String temp = grid[r][c-1];
				grid[r][c-1] = grid[r][c];
				grid[r][c] = temp;
			}else{
			
				if(d.equals("s")){
					String temp =grid[r+1][c];
					grid[r+1][c] = grid[r][c];
					grid[r][c] = temp;
				}else{
					if(d.equals("d")){
						String temp = grid[r][c+1];
						grid[r][c+1] = grid[r][c];
						grid[r][c] = temp;
					}
				}
			}
		}

		return grid;

	}
	public static int[] checkRow(String[] row){
		int[] results = new int[3];
		int longest = 1;
		int longestIndex = 0;
		int temp = 1;
		for(int i = 0;i<row.length;i++){
			int index = i;
			while(index<row.length-1&&row[index] == row[index+1]){

				temp++;
				index++;
			}
			i = index;
			if(longest<temp){
				longest = temp;
				longestIndex = i - (longest-1);
			}
			temp = 1;
		}

		if (longest>=3){
			//System.out.println("found greater than four");
			results[0] = 1;
			results[1] = longest;
			results[2] = longestIndex;
			return results;

		}
		results[0] = 0;
		return results ;

	}
	public static void clearRow(String[] row, int longest, int longestIndex) {
		for(int i = 0; i<longest; i++){
			row[longestIndex+i] = "   ";
		}


	}
	public static  int[] checkCol(String[][]grid, int a){
		int[] results = new int[3];
		int longest = 1;
		int longestIndex = 0;
		int temp = 1;
		for(int i = 0;i<grid.length;i++){
			int index = i;
			while(index<grid.length-1&&grid[index][a] == grid[index+1][a]){

				temp++;
				index++;
			}
			i = index;
			if(longest<temp){
				longest = temp;
				longestIndex = index - (longest-1);

			}
			temp = 1;



		}

		if (longest>=3){
			results[0] = 1;
			results[1] = longest;
			results[2] = longestIndex;
			return results;

		}

		results[0] = 0;
		return results ;

	}
	public static void clearCol(String[][] col, int longest, int longestIndex,int a) {
		for(int i = 0; i<longest; i++){
			col[longestIndex+i][a] = "   ";
		}
	}
	public static void replaceBlank(String[][] grid){
		for(int row= 0; row < grid.length;row++){
			for(int col = 0; col < grid[row].length;col++){
				if(grid[row][col].equals("   ")){
					double rand = Math.random();
					int roll = (int) (AnnaFrontend.symbol.length * rand);
					grid[row][col] = AnnaFrontend.symbol[roll];
				}
			}
		}
	}
	public static void swapBlank(String[][]grid){
		for(int row = grid.length-1; row > 0; row--){
			for(int col = 0; col < grid[0].length-1; col++){
				if(grid[row][col].equals("   ")){
					swap(grid,row,col,"w");
				}

			}
		}
	}
}