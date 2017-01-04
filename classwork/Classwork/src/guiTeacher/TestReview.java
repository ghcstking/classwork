
import java.lang.Math; // headers MUST be above the first class

// one class needs to have a main() method
public class TestReview
{
  
  static boolean[][] grid;
  // arguments are passed using the text field below this editor
  public static void main(String[] args)
  {
    grid = new boolean[5][5];
    printGrid();
    buttonClick(3,3);
    printGrid();
    buttonClick(3,3);
    printGrid();
  }
  
  public static void buttonClick(int r, int c){
   if(r>=0 && r < grid.length) switchRow(grid[r],c);
    switchColumn(grid,r,c);
    for(int row = 0; row < grid.length; row++){
      for(int col = 0 ; col < grid[row].length; col++){
       if(grid[row][col]) return; 
      }
    }
    System.out.println("You won!");
  }
  
  public static void switchRow(boolean[] row, int x){
    for(int i = -1; i < 2; i++){
     	if(x+i  >= 0 && x+i < row.length)row[x+i] = !row[x+i]; 
    }
  }
  
    public static void switchColumn(boolean[][] grid,int r, int c){
     	switchIfValid(grid,r-1,c);
      	switchIfValid(grid,r+1,c);
    
  }
  
  public static void switchIfValid(boolean[][]grid, int r, int c){
    if(r>=0 && r < grid.length && c >= 0 && c < grid[r].length){
     grid[r][c] = !grid[r][c]; 
    }
  }
  
  public static void printGrid(){
    for(boolean[] row: grid){
      for(boolean b: row){
      	if(b)System.out.print("O");
        else System.out.print("X");
      }
      System.out.print("\n");
    }
    System.out.println("- - - - - - - - - - ");
  }
}
