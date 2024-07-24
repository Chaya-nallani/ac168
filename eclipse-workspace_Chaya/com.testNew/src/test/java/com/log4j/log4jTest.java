package com.log4j;

public class log4jTest {

	public void testInfo() {
		int c, a = 10, b = 20;
		c = a + b;
		System.out.println("Value of c :" + c);
		LoggerLoad.info("Info  - Addition of integers");
	}

	public void testError() {
		try {
			int i = 1 / 0;
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			LoggerLoad.error("Error - You can not divide a number by zero");
		}

	}
	public void testWarn() {
		LoggerLoad.warn("Warning - Testing");
	}

	public static void main(String[] args) {

		log4jTest obj = new log4jTest();
		obj.testError();
		obj.testInfo();
		obj.testWarn();
	}
}
