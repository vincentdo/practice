public class Parentheses {

	public static void main(String[] args) {
		String input = args[0];
		boolean[] vector = new boolean[input.length()];
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '(') {
				vector[i] = true;
				boolean paired = false;
				for (int j = 0; j < input.length(); j++) {
					if (input.charAt(i) == input.charAt(j) && !vector[j]) {
						vector[j] = true;
						paired = true;
						break;
					}
				}
				if (!paired) {
					System.out.println("Invalid");
					System.exit(1);
				}
			}
		}

		System.out.println("Valid");
	}
}
