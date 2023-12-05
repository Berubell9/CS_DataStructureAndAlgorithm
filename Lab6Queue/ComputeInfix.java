import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class ComputeInfix {
    MyQueueL queue = new MyQueueL();
    MyStackL stack = new MyStackL();
    Scanner in = new Scanner(System.in);
    String input = in.nextLine();
    StringTokenizer str = new StringTokenizer(input);
    
    private static Pattern pattern= Pattern.compile("-?\\d+(\\.\\d+)?");
    public static boolean isNumeric(String strNum) {
    if (strNum== null) {
        return false; 
    }
    return pattern.matcher(strNum).matches();
}

    public void ShuntingYard(){
        while(str.hasMoreTokens()){
            String t = str.nextToken();
            if(isNumeric(t)){
                queue.enqueue(t);
            }else if(t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/")){
                if(!stack.isEmpty()){
                    while(CompareTop(t, stack.top())){
                        queue.enqueue(stack.pop());
                        if(stack.isEmpty()){
                            break;
                        }
                    }
                }
                stack.push(t);
            }else if(t.equals("(")){
                stack.push(t);
            }else if(t.equals(")")){
                while (!(stack.top().equals("("))) {
                    queue.enqueue(stack.pop());
                }
                stack.pop();
            }
        }
        while(!(stack.isEmpty())) {
            queue.enqueue(stack.pop());
        }

    }

    public boolean CompareTop(String token, String top){
    
        if((stack.top().equals("(") || stack.top().equals(")"))){
            return false;
        }
        if(token.equals("*") || token.equals("/")){
            if(stack.top().equals("+") || stack.top().equals("-")){
                return false;
            }
        }
        return false;
    }

    public String GetAndShowPostflix(){
        String Postfix = "";
        
        System.out.println("Infix : "+input);
        while(!queue.isEmpty()) {
                Postfix += queue.dequeue() + " ";
    
        }
        System.out.println("Postfix : " + Postfix);
        return Postfix;
    }

    public static void main(String[] args) {
        
        ComputeRPN Infix = new ComputeRPN();
        ComputeInfix t = new ComputeInfix();
        t.ShuntingYard();
        Infix.RPN(t.GetAndShowPostflix());
    }
        
    
}
