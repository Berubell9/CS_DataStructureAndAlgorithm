import java.util.Arrays;
import java.util.Comparator;

public class Task1 {
    public static void main (String args[]){
        demo1();
    }
    //ex0
    static void ex0() {
            System.out.println("-ex0---");
            int [] arr = {7, 3, 1, 9, 6, 8, 4, 2, 5};
            System.out.println(Arrays.toString(arr));
            Arrays.sort(arr);
            System.out.println(Arrays.toString(arr));
    }

    //demo1
    static void demo1() {
        System.out.println("-demo1---");
        SillyLuckyNumber [] arr = {
            new SillyLuckyNumber("Terrier"), new SillyLuckyNumber("Jack"),
            new SillyLuckyNumber("Pom"), new SillyLuckyNumber("Beagle")
        };
        System.out.println(Arrays.toString(arr));
        // Comparator<SillyLuckyNumber> engine = new Comparator<>() {
        //     @Override
        //     public int compare(SillyLuckyNumber o1, SillyLuckyNumber o2) {
        //         return Integer.compare(o1.getLuckyNumer(), o2.getLuckyNumer());
        //     }
        // };
        Comparator<SillyLuckyNumber> engine = //your code (sort by luckyNumber);
            (o1,o2) -> Integer.compare (o1.getLuckyNumber(), o2.getLuckyNumber());

        Arrays.sort(arr, engine);
        System.out.println(Arrays.toString(arr));
    }
}
