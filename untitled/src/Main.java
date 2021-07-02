public class Main {
    public static int[][] grid = new int[][]{{0, 0, 0, 0, 0}, {0, 1, 1, 1, 0}, {1, 2, 2, 2, 1}, {1, 1, 1, 1, 1}, {0, 0, 0, 0, 0}};
    public static boolean sucse;
    public static int [][] mark = new int[5][5];
    public static void main(String[] args) {
        input(grid);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <5 ; j++) {

             int color=grid[i][j];
             sucse = true; // нахождение замыкания
             if (color!=0){
  //               mark[i][j]=1; // =1 посетили эту вершину
                 floodfill(color,i,j);
                 input(mark);


             }
            }

        }


    }

    private static void input(int[][] grid) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <5 ; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
        System.out.println("---------------");
    }
    public static void floodfill(int color, int col, int row){

        if (!sucs(col,row)){
            sucse=false;
            return;
        }
        if (col + 1 < 5)
        {
            if ((grid[col + 1][ row] == color) || (mark[col + 1][ row] == 1)) return;
            else { mark[col][ row] = 1; floodfill(color, col + 1, row); }
        }
        if (row + 1 < 5)
        {
            if ((grid[col][ row + 1] == color) || (mark[col][ row + 1] == 1)) return;
            else { mark[col][ row] = 1; floodfill(color, col, row + 1); }
        }
        if (col - 1 >= 0)
        {
            if ((grid[col - 1][ row] == color) || (mark[col - 1][ row] == 1)) return;
            else { mark[col][ row] = 1; floodfill(color, col - 1, row); }
        }
        if (row - 1 >= 0)
        {
            if ((grid[col][ row - 1] == color) || (mark[col][ row - 1] == 1)) return;
            else { mark[col][ row] = 1; floodfill(color, col, row - 1);}
        }



    }
    public static boolean sucs (int col, int row){
        boolean res = true;
        if (col + 1 < 5) { if (grid[col + 1][ row] == 0) res = false; }
        if (row + 1 < 5) { if (grid[col ][ row+1] == 0) res = false; }
        if (col - 1 >= 0) { if (grid[col -1][ row] == 0) res = false; }
        if (row - 1 >= 0) { if (grid[col ][ row-1] == 0) res = false; }
        return res; // если сосед =0
    }


}
