import java.util.ArrayList;

public class dicecombination {
    public static void main(String[] args) {

        roll("", 3);
        System.out.println(rolldice("" ,3));
        System.out.println(count("" ,3));
    }
    public static int count(String p, int target){
        if(target == 0){
            return 1;
        }
        int count =0;
        for (int i = 1; i <=6 && i<= target; i++) {
            count =count+ count(p+ i,target -i);

        }
        return count;
    }

    public static ArrayList<String> rolldice(String p, int target) {
        if(target == 0){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list =new ArrayList<>();
        for (int i = 1; i <= 6 && i<= target; i++) {
            list.addAll(rolldice(p+i,target-i));
        }
        return list;
    }

    public static void roll(String p,int target){
        if(target == 0){
            System.out.println(p);
            return;
        }
        for (int i = 1; i <=6 && i<= target; i++) {
            roll(p+i,target-i);

        }
    }
}
