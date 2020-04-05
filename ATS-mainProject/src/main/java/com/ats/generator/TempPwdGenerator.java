package com.ats.generator;

import java.util.Random;

public class TempPwdGenerator {
	
	public static String generateTempPwd() {
		Random rand = new Random();
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String randomString = "";
		int length = 5;
		char[] text = new char[length];
		for (int i = 0; i < length; i++) {
			text[i] = characters.charAt(rand.nextInt(characters.length()));
		}
		for (int i = 0; i < text.length; i++) {
			randomString += text[i];
		}
		int second = rand.nextInt(1000);

		String tempPassword = randomString + second;
		return tempPassword;
	}

}
