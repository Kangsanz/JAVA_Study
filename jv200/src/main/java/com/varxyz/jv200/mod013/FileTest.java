package com.varxyz.jv200.mod013;

import java.io.File;

public class FileTest {
	private static final String SAVE_DIR1 = "C:/temp";
	private static final String SAVE_DIR2 = "C:/temp";

	public static void main(String[] args) {
		File saveDir1 = new File(SAVE_DIR1);
		System.out.println(saveDir1.getPath());
		System.out.println("Window :" + File.separator);

		File saveDir2 = new File(SAVE_DIR2);
		System.out.println(saveDir2.getPath());
	}
}
