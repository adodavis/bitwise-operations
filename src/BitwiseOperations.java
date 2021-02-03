// Programmer: Adonis Davis
// Project: Bitwise Operations

import java.util.Scanner;

public class BitwiseOperations {
	// Returns integer bit value
	static int intRet(String bitString, int index) {
		int bit = Integer.parseInt(bitString.substring(index, index + 1));
		
		return bit;
	}
	
	// Performs bitwise AND operation and returns the value
	static String bitAnd(String a, String b) {
		String andString = "";
		
		for (int i = 0; i < a.length(); i++) {
			char bit1 = a.charAt(i);
			char bit2 = b.charAt(i);
			int bitResult = Character.getNumericValue(bit1) & Character.getNumericValue(bit2);
			char bit = (char)(bitResult + '0');
			andString += bit;
		}
		
		return andString;
	}
	
	// Performs bitwise OR operation and returns the value
	static String bitOr(String a, String b) {
		String orString = "";
		
		for (int i = 0; i < a.length(); i++) {
			char bit1 = a.charAt(i);
			char bit2 = b.charAt(i);
			int bitResult = Character.getNumericValue(bit1) | Character.getNumericValue(bit2);
			char bit = (char)(bitResult + '0');
			orString += bit;
		}
		
		return orString;
	}
	
	// Performs bitwise XOR operation and returns the value
	static String bitXor(String a, String b) {
		String xOrString = "";
		
		for (int i = 0; i < a.length(); i++) {
			char bit1 = a.charAt(i);
			char bit2 = b.charAt(i);
			int bitResult = bit1 ^ bit2;
			char bit = (char)(bitResult + '0');
			xOrString += bit;
		}
		
		return xOrString;
	}


	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter the length of two bitwise strings: ");
		String len = scan.next();
		
    // Ensures valid input
		while (!len.matches("\\d+")) {
			System.out.println("\nError: Only numbers are allowed.");
			System.out.print("Enter the length of two bitwise strings: ");
			len = scan.next();
		}
		
		int length = Integer.parseInt(len);
		
		System.out.print("Enter a bitwise string of length " + length + ": ");
		String operand = scan.next();
		
		// Ensures string matches user-entered length
		while (operand.length() != length) {
			System.out.println("\nError: String must be of length " + length);
			System.out.print("Enter a bitwise string of length " + length + ": ");
			operand = scan.next();
		}
		
		// Ensures entry only contains bits
		for (int i = 0; i < operand.length(); i++) {
			int bitCheck = intRet(operand, i);
			
			while (bitCheck < 0 || bitCheck > 1) {
				System.out.println("\nError: Bits must be 0's or 1's");
				System.out.print("Enter a bitwise string of length " + length + ": ");
				operand = scan.next();
				bitCheck = Integer.parseInt(operand.substring(i, i + 1));
			}
		}
		
		System.out.print("Enter another bitwise string of length " + length + ": ");
		String operand2 = scan.next();
		
		// Ensures string matches user-entered length
		while (operand2.length() != length) {
			System.out.println("\nError: String must be of length " + length);
			System.out.print("Enter a bitwise string of length " + length + ": ");
			operand2 = scan.next();
		}
		
		// Ensures entry only contains bits
		for (int i = 0; i < operand2.length(); i++) {
			int bitCheck = intRet(operand2, i);
			
			while (bitCheck < 0 || bitCheck > 1) {
				System.out.println("\nError: Bits must be 0's or 1's");
				System.out.print("Enter a bitwise string of length " + length + ": ");
				operand2 = scan.next();
				bitCheck = Integer.parseInt(operand2.substring(i, i + 1));
			}
		}
		scan.close();
		
		// Prints the results
		System.out.println(operand + " AND " + operand2 + " = " + bitAnd(operand, operand2));
		System.out.println(operand + " OR " + operand2 + " = " + bitOr(operand, operand2));
		System.out.println(operand + " XOR " + operand2 + " = " + bitXor(operand, operand2));
	}

}
