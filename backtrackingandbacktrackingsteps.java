import java.util.Arrays;

public class Backtracking {
    public static void main(String[] args) {
        boolean[][] arr= {
         {true,true,true}
        ,{true,true,true}
        ,{true,true,true}
        };
      System.out.println("backtracking");
        backtracking("", arr,0,0);
        System.out.println("__________________________");
        System.out.println("backtracking steps");
        int[][] path= new int[arr.length][arr[0].length];
        backtrackingsteps("", arr, 0,0,path,1);

    }
    public static void backtracking(String p,boolean[][] arr,int row, int col){
        if (row == arr.length - 1 && col == arr[0].length -1) {
            System.out.println(p);
            return;
        }
        if (!arr[row][col]) {
            return;
        }

        arr[row][col] = false;
       if(row< arr.length-1){
           backtracking(p+'D',arr,row+1,col);
       }
       if(col< arr[0].length-1){
           backtracking(p+'R',arr,row,col+1);
       }
        if(row> 0){
            backtracking(p+'U',arr,row-1,col);
        }
        if(col> 0){
            backtracking(p+'L',arr,row,col-1);
        }
        arr[row][col] =true;

    }
    public static void backtrackingsteps(String p,boolean[][] arr,int row, int col,int[][] path,int step){
        if (row == arr.length - 1 && col == arr[0].length -1) {
            path[row][col] =step;
       for(int i[]: path){
           System.out.println(Arrays.toString(i));
       }
                System.out.println(p);
            return;
        }
        if (!arr[row][col]) {
            return;
        }

        arr[row][col] = false;
        path[row][col] =step;
        if(row< arr.length-1){
            backtrackingsteps(p+'D',arr,row+1,col,path,step+1);
        }
        if(col< arr[0].length-1){
            backtrackingsteps(p+'R',arr,row,col+1,path,step+1);
        }
        if(row> 0){
            backtrackingsteps(p+'U',arr,row-1,col,path,step+1);
        }
        if(col> 0){
            backtrackingsteps(p+'L',arr,row,col-1,path,step+1);
        }
        arr[row][col] =true;
        path[row][col] =0;
  }



}
