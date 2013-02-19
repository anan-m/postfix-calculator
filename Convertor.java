import ch03.stacks.*;


public class Convertor {
public static String toPostFix(String infixbuffer){
	String postfixline = "";
	BoundedStackInterface<String> stack = new ArrayStack<String>(50);

	for (int i = 0; i < infixbuffer.length(); i++)
	{
		char ch = infixbuffer.charAt(i);
    	String temp = Character.toString(ch);
//	    System.out.println("i= " +i+" ch= "+ch +" postfixline= "+ postfixline );
	    if(isOpen(ch))
        {
            stack.push(temp);
	    }else if(isOperand(ch))
        {
            postfixline +=  ch;
	    }
        else if (isOperator(ch)) {
        	while ((!stack.isEmpty())&&(prcd(stack.top(),temp))){
                String topSymb = stack.top();
                postfixline += " " + topSymb;
//                System.out.println(stack.top() + " " + temp + "  "+ prcd(stack.top(),temp));
                stack.pop();
            }
            stack.push(temp);
            postfixline += " ";
             }
        else if (isClose(ch)) {
            while ((!stack.isEmpty())&&(!stack.top().equals("("))){
                String topSymb = stack.top();
                postfixline += " " + topSymb;
                stack.pop();
            }
          if ((stack.top().equals("("))){
                stack.pop();
            }
        }
    }
	while(!stack.isEmpty()){
        String topSymb = stack.top();
        postfixline += " " + topSymb;
        stack.pop();
    }
    return postfixline;
}
 static   boolean prcd(String one, String two){
    int onePrcd = 0;
    int twoPrcd = 0;
    if ((one.equals("+")) || (one.equals("-"))){
        onePrcd = 1;
    }
    if ((two.equals("+")) || (two.equals("-"))){
        twoPrcd = 1;
    }
    if ((one.equals("*")) || (one.equals("/"))){
        onePrcd = 2;
    }
    if ((two.equals("*")) || (two.equals("/"))){
        twoPrcd = 2;
    }
//    System.out.println(one+" "+onePrcd+" "+two+"  "+twoPrcd);
    if (onePrcd >= twoPrcd){
        return true;
    } else {
        return false;
    }
}
static boolean isOperator(char element)
 {
     if(element == '*' || element == '-' || element == '/' || element == '+')
         return true;
     else
         return false;
 } 
static boolean isOperand(char element)
 {
	 if ((element == '0') || (element == '1') || (element == '2') || (element == '3') || (element == '4') ||
             (element == '5') || (element == '6') || (element == '7') || (element == '8') || (element == '9'))
         return true;
     else
         return false;
 } 
static boolean isClose(char element)
{
	 if ((element == ')'))
        return true;
    else
        return false;
} 
static boolean isOpen(char element)
{
	 if ((element == '('))
        return true;
    else
        return false;
} 
}