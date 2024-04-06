import java.util.ArrayList;

public class StringPermutation {
    public static void main(String[] args) {
        //permutation("","abc");
        ArrayList<String> list= permutationArray("","abcd");
        System.out.println(list);

        int count= permutationCount("","abcd");
        System.out.println(count);
    }
    public static void permutation(String p,String up){
     if(up.isEmpty()){
         System.out.println(p);
         return;
     }

     char ch = up.charAt(0);
     for(int i =0;i<= p.length(); i++){
         String f= p.substring(0,i);
         String s= p.substring(i,p.length());
         permutation(f+ch+s,up.substring(1));
     }
    }
    public static ArrayList<String> permutationArray(String p,String up){
        if(up.isEmpty()){
            ArrayList<String> list= new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans= new ArrayList<>();
        char ch =up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f= p.substring(0,i);
            String s= p.substring(i,p.length());
            ans.addAll(permutationArray(f+ch+s,up.substring(1)));

        }
        return ans;
    }
    public static int permutationCount(String p,String up) {
        if (up.isEmpty()) {

            return 1;
        }
        int count = 0;

        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            count = count + permutationCount(f + ch + s, up.substring(1));
        }
        return count;
    }
}
