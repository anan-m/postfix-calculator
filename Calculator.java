

import java.util.Scanner;

public class Calculator {
	public static String Convert(String expression)
	{
    String line = null; 
    String postfixline = null;
    line=expression;
    postfixline=Convertor.toPostFix(line);
    System.out.println("converted to postfix:");
    System.out.println(postfixline);
//    int result = PostFixEvaluator.evaluate(postfixline);
//    System.out.println(result);
    return postfixline;
	}
}