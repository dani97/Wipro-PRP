package com.wipro.bank.acc;

public class RDAccount extends Account {

	public RDAccount(int tenure, float principal) {
		this.principal = principal;
		this.tenure = tenure;
		// TODO Auto-generated constructor stub
	}

	@Override
	public float calculateInterest() {
		// TODO Auto-generated method stub
		float temp =(float) (this.principal*(Math.pow((float)(1+this.rateOfInterest/(float)4), this.tenure*4)-1));
		return temp;
	}

	@Override
	public float calculateAmountDeposited() {
		// TODO Auto-generated method stub
		return this.principal*this.tenure*12;
	}

}
