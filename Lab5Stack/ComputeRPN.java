import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class ComputeRPN {
    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
    public static void main(String[] args) {
        MyStackA stack = new MyStackA();
        //MyStackL stack2 = new MyStackL();
        System.out.println(stack.toString()); 
        Scanner sc = new Scanner(System.in);
        String rpn = sc.nextLine();
        StringTokenizer st = new StringTokenizer(rpn);

        // while(st.hasMoreTokens()){
        //     String t = st.nextToken();
        //     System.out.println(t+" is a number -> "+isNumeric(t));
        // }

        while(st.hasMoreTokens()){
            String t = st.nextToken();
            if(isNumeric(t)){
                stack.push(Double.parseDouble(t));
            }
            else{
                double a = stack.pop();
                double b = stack.pop();
                double total = Integer.MIN_VALUE;
                switch(t){
                    case "+":
                        total = b+a;
                        break;
                    case "-":
                        total = b-a;
                        break;
                    case "*":
                        total = b*a;
                        break;
                    case "/":
                        total = b/a;
                        break;
                }
                stack.push(total);
            }
        }
        System.out.println("result : "+stack.pop());
        sc.close();
    }
    public static boolean isNumeric(String strNum){
        if(strNum == null){
            return false;
        }
        return pattern.matcher(strNum).matches();
    }
}
