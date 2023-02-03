import java.util.Random;
import java.util.Scanner;

public class CodeForce {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = Integer.parseInt(in.nextLine());
        String str = in.nextLine();
        int len = str.length();
        StringBuilder t = new StringBuilder(str);
        Random rand = new Random();

        for (int j = 0; j < x; j++) {
            System.out.println(1);
            int r_edit = rand.nextInt(3) + 1;
            int i = 1;
            while (i <= r_edit) {

                int r_index1 = rand.nextInt(len);
                int r_index2 = rand.nextInt(len);
//                if (i==2) {
//                    System.out.println(r_index2);
//                    System.out.println(r_index1);
//                }
                while(r_index1==r_index2){
                    r_index2 = rand.nextInt(len);
                    r_index1 = rand.nextInt(len);
                }
                char symbol = t.charAt(r_index1);
                t.setCharAt(r_index1, t.charAt(r_index2));
                t.setCharAt(r_index2,symbol);



                i++;
            }
            System.out.println(t);
        }
    }
}
