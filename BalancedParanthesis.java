package LabAssignment;

import java.util.Stack;

public class BalancedParanthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "( [ [ { } ] ] ) )";
		boolean result = isParanthesisBalanced(input);
		if (result) {
			System.out.println("The entered String has Balanced Brackets");
		} else {
			System.out.println("The entered Strings do not contain Balanced Brackets");
		}
	}

	private static boolean isParanthesisBalanced(String input) {
		Stack<Character> stack = new Stack<Character>();
		char[] inputArray = input.toCharArray();
		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i] == '(' || inputArray[i] == '[' || inputArray[i] == '{') {
				stack.push(inputArray[i]);
				continue;
			}
			if (stack.isEmpty()) {
				return false;
			}
			char c;
			switch (inputArray[i]) {

			case ')':
				c = stack.pop();
				if (c == '[' || c == '{') {
					return false;
				}
				break;
			case ']':
				c = stack.pop();
				if (c == '(' || c == '{') {
					return false;
				}
				break;
			case '}':
				c = stack.pop();
				if (c == '[' || c == '(') {
					return false;
				}
				break;
			}
		}
		if (stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}
