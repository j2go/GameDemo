import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Java8 的遍历测试
 * Created by shitiangao on 16/5/23.
 */
public class ForeachTest {

    public static void main(String[] args) {
        Random random= new Random();
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10000; i++) {
            list.add(random.nextInt());
        }
        long start = System.currentTimeMillis();
        for (int i: list) {
            System.out.print(i);
        }
        long end = System.currentTimeMillis();
        System.out.println();
        System.out.println(end-start);

        start = System.currentTimeMillis();
        list.forEach(System.out::print);
        end = System.currentTimeMillis();
        System.out.println();
        System.out.println(end-start);
    }
}
