
class Task5{
    public static void main(String[] args) {
        demo5();
    }
    static void demo5() {
        System.out.println("-demo5----");
        MyArrDemo<SillyLuckyNumber> arr = new MyArrDemo<>();
        arr.add(new SillyLuckyNumber("Terrier"));
        arr.add(new SillyLuckyNumber("Jack"));
        arr.add(new SillyLuckyNumber("Pom"));
        arr.add(new SillyLuckyNumber("Beagle"));
        arr.add(new SillyLuckyNumber("Cocker Spaniel"));
        arr.add(new SillyLuckyNumber("Basenji"));
        System.out.println(arr);
        selectionSort(arr);
        System.out.println(arr);
    }
    public static void selectionSort(MyArrDemo<SillyLuckyNumber> arr){
        int n = arr.currentSize();
        for(int i=0 ; i < n-1 ; i++){
            int min = i;
            for(int j = i+1 ;j<n ; j++){
                if(arr.get(j).getLuckyNumber()<arr.get(min).getLuckyNumber()){
                    min=j;
                }
            }
        arr.swap(min,i);
        }

    }
}
    
    