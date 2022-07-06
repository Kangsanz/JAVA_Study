package com.varxyz.jv200.mod002;

public class StringActive {
	public static boolean isSubString(String toFind, String string) {
		int i, j;
		boolean found = false;

		for (i = 0; (i < string.length()) && !found; i++) {
			j = 0;
			found = false;
			while (!found) {
				if (j >= toFind.length()) {
					break;
				} else if ((i + j) >= string.length()) {
					break;
				} else if (toFind.charAt(j) != string.charAt(i + j)) {
					break;
				} else {
					j++;
					if (j == toFind.length()) {
						found = true;
					}
				}
			}
		}

		return found;
	}

	public static void main(String[] args) {
		String text = "The cat in the hat.";

		System.out.println("isSubString(\"cat\", \"The cat in the hat.\") " + StringActive.isSubString("cat", text));

		System.out.println("isSubString(\"bat\", \"The cat in the hat.\") " + StringActive.isSubString("bat", text));

		System.out.println("isSubString(\"The\", \"The cat in the hat.\") " + StringActive.isSubString("The", text));

		System.out.println("isSubString(\"hat.\", \"The cat in the hat.\") " + StringActive.isSubString("hat.", text));
	}
}
