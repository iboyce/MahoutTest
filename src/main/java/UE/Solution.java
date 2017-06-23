package UE;

/**
 * Created by xuzhi on 2016/6/24.
 */
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int sc1 = sc.nextInt();

        Solution so = new Solution();
        int dig = so.addDigits(sc1);
        System.out.println("结果为：" + dig);

    }



    public  int addDigits(int num) {



        String s = (new Integer(num)).toString();
        String[] a = s.split("");

        int[] m = new int[a.length-1];

        System.out.println(a.length);
        for (int i=0;i<a.length;i++) System.out.println(a[i]);
        for (int i=1;i<a.length;i++){
            m[i-1] = Integer.parseInt(a[i]);
            System.out.println(m[i-1]);
        }

        if (m.length > 1){

            int sum = 0;
            for (int j=0;j<m.length;j++){
                sum += m[j];
            }
            //System.out.println(sum);

            int value = addDigits(sum);

            return value;

        }else{

            return num;
        }

    }

}

