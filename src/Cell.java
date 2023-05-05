public class Cell implements Comparable<Cell> {
int source;
    int dest;
    int cost;
public Cell(int source,int  dest,int cost){
    this.source=source;

    this.cost=cost;
    this.dest=dest;

}


public String toString(){
    return this.dest + "and the cost :"+ this.cost;
}

    @Override
    public int compareTo(Cell o) {
        if(this.cost>o.cost){
            return 1;
        }
        return -1;
    }
}
