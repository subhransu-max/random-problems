public class NKnights {
    public static void main(String[] args) {
        boolean[][] arr= new boolean[4][4];
        knights(arr,0,0,4);

    }

    public static void knights(boolean[][] arr,int row,int col,int knight){
        if(knight ==0){
            display(arr);
            System.out.println();
            return;
        }
        if(row == arr.length-1 && col == arr.length){
            return;
        }
        if(col == arr.length){
                knights(arr,row+1,0,knight);
                return;
        }
        if(checkif(arr,row,col)){
            arr[row][col] =true;
            knights(arr,row,col+1,knight-1);
            arr[row][col] =false;
        }
        knights(arr,row,col+1,knight);
    }
    public static boolean checkif(boolean[][] arr,int row,int col){
        if(verify(arr,row-2,col-1)){
            if(arr[row-2][col-1]){
               return false;
            }
        }

        if(verify(arr,row-1,col-2)){
            if(arr[row-1][col-2]){
                return false;
            }
        }

        if(verify(arr,row-2,col+1)){
            if(arr[row-2][col+1]){
                return false;
            }
        }

        if(verify(arr,row-1,col+2)){
            if(arr[row-1][col+2]){
                return false;
            }
        }
        return true;
    }
    public static boolean verify(boolean[][] arr,int row,int col){
        if(row>=0 && row<arr.length && col>=0 && col<arr.length){
            return true;
        }
        return false;
    }
    public static void display(boolean[][] arr){
        for(boolean[] row: arr){
            for(boolean element: row){
                if(element){
                    System.out.print("k ");
                }
                else{
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
