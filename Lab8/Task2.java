import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Task2 {
    public static void main (String args[]){
        demo2();
    }
    static void demo2() {
        System.out.println("-demo2----");
        ArrayList<SillyLuckyNumber> list = new ArrayList<>( 
            Arrays.asList(
                new SillyLuckyNumber("Terrier"), new SillyLuckyNumber("Jack"),
                new SillyLuckyNumber("Pom"), new SillyLuckyNumber("Beagle")
        ));
        System.out.println(list);
        Collections.sort(/* your code */ list,Comparator.comparing(SillyLuckyNumber::getLuckyNumber));
        System.out.println(list);
    }
}
