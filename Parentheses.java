public class Parentheses {

	public static void main(String[] args) {
		String input = args[0];
		int pairCount = 0;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '(') {
				pairCount++;
			}
			if (input.charAt(i) == ')') {
				pairCount--; 
			}
			if (pairCount < 0) {
				System.out.println("Invalid!");
				return;
			}
		}

		System.out.println("Valid");
	}
}
