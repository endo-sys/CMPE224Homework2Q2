import java.awt.desktop.SystemEventListener;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner  test = new Scanner(System.in);
        int testcase = test.nextInt();
        int results[] = new int[testcase];
        int count =0;
       while (testcase>0){
           int rowcount = test.nextInt();
           int columncount = test.nextInt();
           int [][] grid  = new int[rowcount][columncount];
           int startrow = test.nextInt();
           int startcolumn = test.nextInt();
           int endrow = test.nextInt();
           int endcolumn = test.nextInt();
           for (int i =0;i<rowcount;i++){
               for (int j =0;j<columncount;j++){
                   grid[i][j]= test.nextInt();
               }
           }
           Graph newgraph = new Graph(grid);
           results[count]= newgraph.Minumumspanningtree(newgraph.getlocation(startrow,startcolumn,grid), 555);
           count++;


testcase--;

       }
       for (int i =0;i<results.length;i++){
           System.out.println(results[i]);
       }

    }
}