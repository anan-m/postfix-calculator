import java.util.Scanner;
import ch03.postfix.*;
   
public class PFixConsole 
  	  {
    public static void main(String[] args)
  	    {
      Scanner conIn = new Scanner(System.in);
  
      String line = null;          // string to be evaluated
      String more = null;          // used to stop or continue processing
      int result;                  // result of evaluation
  
      do
  	      {
        // Get next expression to be processed.
//        System.out.println("Enter a postfix expression to be evaluated: ");
        System.out.println("type your infix expression: ");

       line = conIn.nextLine();
       line = Calculator.Convert(line);
        // Obtain and output result of expression evaluation.
        try
  	        {
        	
          result = PostFixEvaluator.evaluate(line);
  
         // Output result.
          System.out.println();
          System.out.println("answer is = " + result);
        }
        catch (PostFixException error)
  	        {        
          // Output error message.
          System.out.println();
          System.out.println("Error in expression - " + error.getMessage());
        }
  
        // Determine if there is another expression to process.
        System.out.println();
        System.out.print("Evaluate another expression? (Y=Yes): ");
        more = conIn.nextLine();
        System.out.println();
      }
      while (more.equalsIgnoreCase("y"));
  
      System.out.println("Program completed.");
    }
  }
