import java.util.ArrayList;
import java.util.PriorityQueue;

public class Graph {
  public int vertices;

  public ArrayList<Cell> []graph;

  public Graph(int [][]grid){
      int rowcount = grid.length;
      int columncount = grid[0].length;
      int totalcount = rowcount*columncount;
      this.vertices=totalcount;
      this.graph = new ArrayList[totalcount];
      for (int i=0;i<vertices;i++){
          this.graph[i]= new ArrayList<Cell>();
      }
      for (int i = 0;i<rowcount;i++){
          for (int j =0;j<columncount;j++){
              costfinder(i,j,grid);
          }

      }

  }
  public void costfinder(int row,int column,int [][]array) {

int source = getlocation(row,column,array);
int cost1 = array[row][column];
      if (row != 0) {
          int temp = row;
          temp--;
          int cost2 = array[temp][column];
          int dest = getlocation(temp,column,array);
          graph[source].add(new Cell(source,dest,cost1^cost2));
      }

      if (column != 0) {
          int temp =column;
          temp--;
          int dest = getlocation(row,temp,array);
          int cost2 = array[row][temp];
          graph[source].add(new Cell(source,dest,cost1^cost2));
      }
      if (row != array.length - 1) {
          int temp= row;
          temp++;
          int dest =getlocation(temp,column,array);
          int cost2 = array[temp][column];
          graph[source].add(new Cell(source,dest,cost1^cost2));
      }
      if (column != array[0].length - 1) {
          int temp = column;
          temp++;
          int dest = getlocation(row,temp,array);
          int cost2 = array[row][temp];
          graph[source].add(new Cell(source,dest,cost1^cost2));
      }

  }
  public void display(){
      for (int i =0;i<vertices;i++) {
          for (Cell a :graph[i]){
              System.out.println(i+" "+a);
          }
      }
  }
  public int Minumumspanningtree(int starpoint,int endpoint){
      int sum=0;
      PriorityQueue<Cell> priorityQueue = new PriorityQueue<>();
      int visited[]= new int[vertices];

      priorityQueue.add(new Cell(starpoint,0,0));
      ArrayList<Integer>PATH = new ArrayList<>();
    PATH.add(0);
      while (!priorityQueue.isEmpty()){
          int  source = priorityQueue.peek().source;
          int destination = priorityQueue.peek().dest;
          int cost = priorityQueue.peek().cost;
          PATH.add(destination);
          priorityQueue.remove();
          if(visited[destination]==1){
              continue;
          }
          visited[destination]=1;
          sum+=cost;
          for (Cell a : graph[destination]){

              if(visited[a.dest]==0){
                  priorityQueue.add(new Cell(destination,a.dest,a.cost));
              }
          }


      }
      return sum;




  }

public int getlocation(int rowcount,int columncount,int[][]grid){
    return (rowcount*(grid[0].length))+columncount;

      }




  }






