public class Circle {
    public static int[][] grid = new int[][]{{0, 0, 0,0, 0}, {0, 0, 0, 1, 1}, {0, 0, 1, 0, 0}, {1, 1, 1, 1, 1}, {1, 0, 0, 1, 1}};
    public static int[][] visit=new int[5][5];
    public static int col_start;
    public static int row_start;
    public static boolean circle=false;
    public static void main(String[] args) {

     //   System.out.println(deleteBols());
        GameOver gameOver=new GameOver(grid,2);
        gameOver.gameOverCheck(grid,2);
    }
    public static String deleteBols(){
        StringBuilder res;
        for (int i = 0; i <5 ; i++) {
            for (int j = 0; j < 5; j++) {
                int color=grid[i][j];
                if (color!=0) {
                    col_start = i;
                    row_start = j;
                    dfs(i, j,color);
                }
                System.out.println("Visit");
                input(visit);
                System.out.println("Grid");
                input(grid);

                if (circle) {
                    delete_have_neighbor_zero(visit);
                    delete (grid,visit);
                    System.out.println("Delete");}
                circle=false;

                visit=new int[5][5];
            }
        }

        System.out.println("final");
        input(grid);
        res = getGrid();
        return res.toString();
    }

    public static void delete_have_neighbor_zero(int[][] visit) {
        for (int col = 0; col <5 ; col++) {
            for (int row = 0; row <5 ; row++) {
                if (visit[col][row]==9) {
                    if (col + 1 < 5) {
                        if (visit[col + 1][row] == 0) visit[col][row] = 0;
                    }
                    if (row + 1 < 5) {
                        if (visit[col][row + 1] == 0) visit[col][row] = 0;
                    }
                    if (col - 1 >= 0) {
                        if (visit[col - 1][row] == 0) visit[col][row] = 0;
                    }
                    if (row - 1 >= 0) {
                        if (visit[col][row - 1] == 0) visit[col][row] = 0;
                    }
                }
            }

        }
    }


    public static void delete(int[][] grid, int[][] visit) {
        boolean delete_start=true;
        for (int i = 0; i <5 ; i++) {
            for (int j = 0; j <5 ; j++) {
                if (visit[i][j] == 9) {
                    if ((i < 4)) {
                        if (!((visit[i+1][j] == 2) || (visit[i+1][j] == 9))) delete_start = false;
                    }
                    if ((j < 4)) {
                        if (!((visit[i][j+1] == 2) || (visit[i][j+1] == 9))) delete_start = false;
                    }
                    if ((i >0)) {
                        if (!((visit[i-1][j] == 2) || (visit[i-1][j] == 9))) delete_start = false;
                    }
                    if ((j>0)) {
                        if (!((visit[i][j-1] == 2) || (visit[i][j-1] == 9))) delete_start = false;
                    }
                }
            }
        }
        if (delete_start){
            for (int i = 0; i <5 ; i++) {
                for (int j = 0; j <5 ; j++) {
                    if (visit[i][j]==9)
                        grid[i][j]=0;

                }

            }
        }
    }

    private static void dfs(int col, int row, int color) {


        if (grid[col][row]==0) return;
        if (grid[col][row]!=color) { visit[col][row]=9; return;}


        visit[col][row]=1;
        System.out.println("in " + col+" "+row);
        if (col+1<5){if (visit[col+1][row]==0) dfs(col+1,row,color);}
        if ((col+1)<5&&(row+1)<5){ if (visit[col+1][row+1]==0) dfs(col+1,row+1,color); }
        if ((col+1)<5&&(row-1)>=0) {if (visit[col+1][row-1]==0) dfs(col+1,row-1,color);}
        if (row+1<5){ if (visit[col][row+1]==0) dfs(col,row+1,color);}
        if (row-1>=0){if (visit[col][row-1]==0) dfs(col,row-1,color); }
        if (col-1>=0){if (visit[col-1][row]==0) dfs(col-1,row,color); }
        if ((col-1)>=0&&(row+1)<5) {if (visit[col-1][row+1]==0) dfs(col-1,row+1,color);}
        if ((col-1)>=0&&(row-1)>=0){ if (visit[col-1][row-1]==0) dfs(col-1,row-1,color);}


        visit[col][row]=2;
        System.out.println("out " + col+" "+row);
        if ((col_start==col)&&(row_start==row)){
            System.out.println("Circle enable");
            circle=true;
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

    public static StringBuilder getGrid(){
        StringBuilder res= new StringBuilder();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                res.append(grid[i][j]);
            }
        }
        return res;

    }
}
