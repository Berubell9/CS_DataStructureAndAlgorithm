import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Task3{
    public static void main (String args[]){
        demo3();
    }
    static void demo3() {
        System.out.println("-demo3----");
        ArrayList<SillyLuckyNumber> list = new ArrayList<>( Arrays.asList(
            new SillyLuckyNumber("Terrier"), new SillyLuckyNumber("Jack"),
            new SillyLuckyNumber("Pom"), new SillyLuckyNumber("Beagle")
        ));
        System.out.println(list);
        list.sort(Comparator.comparing(SillyLuckyNumber::getLuckyNumber));
        System.out.println(list);
        // demo shallow copy
        ArrayList<SillyLuckyNumber> anotherList = new ArrayList<>(list.subList(0, list.size()));
        anotherList.get(0).setBreed("newBreed"); //Terrier
        System.out.println(list); //notice how Terrier in list is also effected
    }
}