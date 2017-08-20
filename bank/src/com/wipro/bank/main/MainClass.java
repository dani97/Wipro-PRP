package com.wipro.bank.main;

import com.wipro.bank.service.BankService;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

            int tenure = 5;

            float principal = 1000;

            int age = 23;

            String gender = "Male";

            BankService b=new BankService();

            b.calculate(principal, tenure, age, gender);


	}

}
