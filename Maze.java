// Maze problem for moving right and down only.
import java.util.ArrayList;

public class Maze {


    public static void main(String[] args) {
        int ans = maze(3,3);
        System.out.println(ans);
        mazepossiblestep("",3,3);
        ArrayList<String> list = mazepossiblestepArrays("", 3,3);
        System.out.println(list);
        ArrayList<String> list2 = mazepossiblestepArraysDiagonal("", 3,3);
        System.out.println(list2);
        boolean[][] check= {
                {true ,true, true},
                {true,false,true},
                {true,true,true}
        };
        mazeobstacle("",check,0,0);
    }
    public static int maze(int row,int col){
        if(row==1 || col==1){
            return 1;
        }
        int right= maze(row-1, col);
        int down = maze(row, col-1);
        return right + down;
    }
    public static void mazepossiblestep(String p, int row, int col){
        if(row==1 && col==1){
            System.out.println(p);
            return;
        }
        if(row>1){
            mazepossiblestep(p+"R",row-1, col);
        }
        if(col>1){

            mazepossiblestep(p+"D",row, col-1);
        }
    }public static ArrayList<String> mazepossiblestepArrays(String p, int row, int col){
        if(row==1 && col==1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();

        if(row>1){
            list.addAll(mazepossiblestepArrays(p+"R",row-1, col));
        }
        if(col>1){

            list.addAll(mazepossiblestepArrays(p+"D",row, col-1));
        }
        return list;
    }
    public static ArrayList<String> mazepossiblestepArraysDiagonal(String p, int row, int col){
        if(row==1 && col==1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();

        if(row>1){
            list.addAll(mazepossiblestepArraysDiagonal(p+"V",row-1, col));
        }
        if(row>1 && col>1){
            list.addAll(mazepossiblestepArraysDiagonal(p+"D",row-1, col-1));
        }

        if(col>1){

            list.addAll(mazepossiblestepArraysDiagonal(p+"H",row, col-1));
        }

        return list;
    }

    public static void mazeobstacle(String p,boolean[][] check,int row ,int col){
        if(row ==check.length-1 && col ==check[0].length-1){
            System.out.println(p);
            return;
        }

        if(!check[row][col]){
            return;
        }
        if(row<check.length-1){
            mazeobstacle(p+"D",check,row+1,col);
        }
        if(col< check[0].length-1){
            mazeobstacle(p+"R",check,row,col+1);
        }

    }
}
