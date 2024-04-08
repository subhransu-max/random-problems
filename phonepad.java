import java.util.ArrayList;

public class phonepad {
    public static void main(String[] args) {
        padvoid("","12");
        System.out.println(pad("","12"));
        System.out.println(count("","12"));
    }

    private static int count(String p, String up) {
        if(up.isEmpty()){
            return 1;
        }
        int c= up.charAt(0)-'0';
        int count =0;
        for (int i = (c-1)*3; i < c*3; i++) {
            char ch = (char)('a'+i);
           count =count + count(p+ch, up.substring(1));
        }
        return count;

    }

    public static void padvoid(String p, String up) {
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        int c= up.charAt(0)-'0';
        for (int i = (c-1)*3; i < c*3; i++) {
            char ch = (char)('a'+i);
            padvoid(p+ch, up.substring(1));
        }
    }

    public static ArrayList<String> pad(String p, String up){
        if(up.isEmpty()){
          ArrayList<String> list = new ArrayList<>();
          list.add(p);
          return list;
        }
        int c = up.charAt(0) - '0';
        ArrayList<String> list = new ArrayList<>();

        for (int i = (c-1)*3; i <c*3; i++) {
            char ch =(char)('a'+i);
            list.addAll(pad(p+ch,up.substring(1)));
        }
        return list;
    }
}
