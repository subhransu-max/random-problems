public class NQueens {
    public static void main(String[] args) {
        int n=4;
        boolean[][] arr= new boolean[n][n];
        int a= count(arr,0);
        System.out.println(a);


    }
    public static int count(boolean[][] arr, int row){
        if(row ==arr.length){
            display(arr);
            System.out.println();
            return 1;
        }
        int count =0;
        for (int col = 0; col < arr.length; col++) {
           if(checkif(arr, row, col)){
               arr[row][col] =true;
               count+= count(arr, row +1);
               arr[row][col] = false;
           }

        }
        return count;
    }

    private static boolean checkif(boolean[][] arr, int row, int col) {
        // for up
        for (int i = 0; i < row; i++) {
            if(arr[i][col]){
                return false;
            }
        }
            //for diagonal left
        int left= Math.min(row, col);
        for (int j = 1; j <= left; j++) {
            if(arr[row-j][col-j]){
                return false;
            }
        }
        //for diagonl right
        int maxRight = Math.min(row, arr.length - col - 1);
        for (int j = 1; j <=maxRight; j++) {
            if(arr[row-j][col+j]){
                return false;
            }
        }
        return true;
    }

    public static void display(boolean[][] arr){
        for(boolean[] i: arr){
            for(boolean j: i){
                if(j){
                    System.out.print("Q ");
                }
                else{
                    System.out.print("X ");
                }

            }
            System.out.println();

        }
    }
}
