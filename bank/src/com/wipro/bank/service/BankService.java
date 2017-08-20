package com.wipro.bank.service;

import com.wipro.bank.acc.RDAccount;
import com.wipro.bank.exception.BankValidationException;

public class BankService {
	public boolean validateData(float principal, int tenure,int age, String gender){
		try{
		if(!(principal>=500||tenure==5||tenure==10&&gender.equalsIgnoreCase("Male")||gender.equalsIgnoreCase("Femle")&&age>=1&&age<=100)){
			throw new BankValidationException();
		}
		}
		catch(BankValidationException e){
			return false;
		}
		return true;
	}
	
	public void calculate(float principal,int tenure, int age, String gender){
		if(validateData(principal,tenure, age, gender)){
			RDAccount rda = new RDAccount(tenure,principal);
			rda.setInterest(age, gender);
			System.out.println(rda.calculateAmountDeposited());
			float totalPrincipleDeposited = rda.calculateAmountDeposited();
			int maturityInterest = tenure;
			System.out.println(rda.calculateMaturityAmount(totalPrincipleDeposited, maturityInterest));
		}
	}

}
