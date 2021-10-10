import java.util.*;

class CompImpl implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 % 10 < o2 % 10) {
            return 1;
        }

        return -1;
    }
}

public class test {
    public static void main(String[] args) {
        List<Integer> li = new LinkedList<>();
        li.add(305);
        li.add(998);
        li.add(774);
        li.add(236);
        li.add(881);

        Comparator<Integer> comp = new CompImpl();
        Collections.sort(li, comp);
        System.out.println(li);
    }
}
