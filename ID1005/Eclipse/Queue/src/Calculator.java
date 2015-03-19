import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * The purpose of this program is to take a String expression with basic math
 * operators +*-/ and parenthesis as input return the final result.
 */
public class Calculator
{
	// The basic operations
	public enum Operation
	{
		Add, Subtract, Multiply, Divide
	}
	/**
	 * Computation is processed here.
	 * 
	 * @param num1
	 * @param num2
	 * @param operation
	 * @return
	 */
	public BigDecimal doBasicMath(BigDecimal num1, BigDecimal num2,
			Operation operation)
	{
		BigDecimal returnval = BigDecimal.ZERO;
		switch (operation) //Basic operations are performed here.
		{
			case Add :
				returnval = num1.add(num2);
				break;
			case Subtract :
				returnval = num1.subtract(num2);
				break;
			case Multiply :
				returnval = num1.multiply(num2);
				break;
			case Divide :
				returnval = num1.divide(num2, 4, RoundingMode.HALF_UP);
				break;
		}
		return returnval;
	}
	/**
	 * Does math processing.
	 * 
	 * @param list
	 * @return
	 */
	public BigDecimal doMath(List<String> list)
	{
		int i = 0;
		BigDecimal result = BigDecimal.ZERO;
		Object[] strArr = list.toArray();
		String temp = "";
		int length = strArr.length;
		for (i = 0; i < length; i++)
		{
			temp = strArr[i].toString();
			if (temp.equals("*") || temp.equals("/")) //Perform the Multiply and Divide operation here.
			{
				BigDecimal num1 = new BigDecimal(strArr[i - 1].toString());
				BigDecimal num2 = new BigDecimal(strArr[i + 1].toString());
				result = doBasicMath(num1, num2, temp.equals("*")
						? Operation.Multiply
						: Operation.Divide);
				strArr[i + 1] = result.toString();
				strArr[i - 1] = "0";
				strArr[i] = "0";
			}
		}
		result = BigDecimal.ZERO;
		for (i = 0; i < length; i++)
		{
			String n = strArr[i].toString();
			if (!n.equals("+"))
			{
				result = result.add(new BigDecimal(n));
			}
		}
		return result;
	}
	/**
	 * Simple expression is processed here.
	 * 
	 * @param input
	 * @return
	 */
	public BigDecimal simpleExpression(String input)
	{
		Pattern p = Pattern.compile("(\\.\\d+)|(\\d+\\.?\\d*)");
		List<String> list = new LinkedList<String>();
		Matcher m = p.matcher(input);
		int length = input.length();
		int startIndex = 0;
		int endIndex = 0;
		char c = 'a';
		String negative = "";
		while (m.find())
		{
			startIndex = m.start();
			endIndex = m.end();
			if (startIndex == 1)
			{
				negative = "-";
			}
			if (endIndex < length)
			{
				c = input.charAt(endIndex);
				list.add(negative + (m.group().toString()));
				negative = c == '-' ? "-" : "";
				if (c == '-')
				{
					list.add("+");
				} else
				{
					list.add("" + c);
				}
			} else
			{
				list.add(negative + (m.group().toString()));
			}

		}
		return doMath(list);
	}
	/**
	 * String expression is processed here
	 * 
	 * @param input
	 * @return
	 */
	public String performStringExpr(String input)
	{
		Stack<String> stack = new Stack<String>();
		StringBuilder temp = new StringBuilder();
		String ans = "";
		int i = 0;
		int length = input.length();
		char c = '0';
		while (i < length)
		{
			c = input.charAt(i);
			if (c == '(')
			{
				stack.push(temp.toString());
				temp = new StringBuilder();
			} else if (c == ')')
			{
				String inpForsimpleExpr = temp.length() == 0
						? stack.pop()
						: temp.toString();
				if (startsWithOperator(inpForsimpleExpr))
				{
					ans = inpForsimpleExpr;
				} else
				{
					ans = performStringExpr(inpForsimpleExpr);
				}
				String t = stack.pop() + ans;
				stack.push(t);
				temp = new StringBuilder();
			} else
			{
				temp.append(c);
			}
			i++;
		}
		String ele = "";

		if (temp.toString().equals(""))
		{
			ele = stack.isEmpty() ? "" : stack.pop();
			if (startsWithOperator(ele))
			{
				String t1 = stack.pop();
				stack.push(t1 + ele);
			} else
			{
				stack.push(ele);
			}
		}
		String inputforSE = stack.isEmpty() ? temp.toString() : stack.pop();
		// Just in case the internal expressions evaluate to a -ve value and
		// the immediate preceding operator is + then change to - or if
		// the immediate preceding operator is - then change to +
		inputforSE = inputforSE.replaceAll("\\+-", "-");
		inputforSE = inputforSE.replaceAll("--", "-");
		return "" + simpleExpression(inputforSE);
	}
	/**
	 * Returns true if temp1 starts with operator
	 * 
	 * @param temp1
	 * @return
	 */
	private boolean startsWithOperator(String temp1)
	{
		return temp1.startsWith("*") || temp1.startsWith("+")
				|| temp1.startsWith("/") || temp1.startsWith("-")
				|| temp1.endsWith("*") || temp1.endsWith("/")
				|| temp1.endsWith("+") || temp1.endsWith("-");
	}
	/**
	 * Validates the User input.
	 * 
	 * @param input
	 * @return
	 */
	public boolean validateUserInput(String input)
	{
		boolean isvalid = true;
		int parenCount = 0;
		String temp = input;
		// Remove all arithmetic operators.
		temp = temp.replaceAll("[\\d\\*\\+\\(\\)-\\./]", "");
		if (temp.length() > 0)
		{
			isvalid = false;
		} else
		{
			temp = input.replaceAll("[\\d\\*\\+-\\./]", "");
			for (int i = 0; i < temp.length(); i++)
			{
				// Check for paranthesis.
				if (temp.charAt(i) == '(')
				{
					parenCount++;
				} else if (temp.charAt(i) == ')')
				{
					parenCount--;
				}
			}
			if (parenCount != 0)
			{
				isvalid = false;
			}
		}
		return isvalid;
	}
	/**
	 * Launch method.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{   	//Tests 
		Calculator m = new Calculator();
		System.out.println("Tests");
		if (m.performStringExpr("1+2*3").equals("7")){
			System.out.println("1)Test passed");
		}else{
			System.out.println("1)Test Failed");
		}
		if (m.performStringExpr("1/2*3").equals("1.5000")){
			System.out.println("2)Test passed");
		}else{
			System.out.println("2)Test Failed");
		}
		if (m.performStringExpr("1/2*3+3-1").equals("3.5000")){
			System.out.println("3)Test passed");
		}else{
			System.out.println("3)Test Failed");
		}
		System.out.println("Enter the simple Math Expression :");
		Scanner n = new Scanner(System.in);
		String input = (n.nextLine()).replaceAll("\\s*", "");
		if (m.validateUserInput(input))
		{
			System.out.println("Expression :" + input);
			System.out.println("Result :" + m.performStringExpr(input));
		} else
		{
			System.out.println("Invalid Input");
		}
	
	}
	
	
}
