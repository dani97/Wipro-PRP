package com.wipro.power.service;

import java.util.ArrayList;

import com.wipro.power.bean.PowerRateBean;
import com.wipro.power.bean.ReadingBean;
import com.wipro.power.dao.PowerRateDao;
import com.wipro.power.dao.ReadingDao;

public class PowerMain {
	public String generateBill(ReadingBean bean)
	{
		if(bean == null || bean.getPresentReading()<bean.getPastReading()) return "INVALID";
		if(!(bean.getType().equals("house")||bean.getType().equals("mall")||bean.getType().equals("shop")))
			return "INVALID TYPE";
		int unitsUsed = bean.getPresentReading()-bean.getPastReading();
		float amount = calculateAmount(unitsUsed,bean.getType());
		bean.setUnitsUsed(unitsUsed);
		bean.setAmount(amount);
		String stat = new ReadingDao().CreateReading(bean);
		if(stat.equals("failure"))
		{
			return "FAIL";
		}
		return ("BILLAMOUNT:"+amount);
	}
	
	

	public float calculateAmount(int units,String type)
	{
		PowerRateBean bean = new PowerRateDao().findRateByType(type);
		float amount = 0;
		if(units<=bean.getSlab2())
		{
			return bean.getSlab1rate()*units;
		}
		else
		{
			amount += bean.getSlab1rate()*bean.getSlab2(); 
		}
		int remunits = units-bean.getSlab2();
		
		if(units<=bean.getSlab3())
		{
			return bean.getSlab2rate()*remunits+amount;
		}
		else
		{
			amount += bean.getSlab2rate()*(bean.getSlab3()-bean.getSlab2()); 
		}
		remunits = remunits-bean.getSlab2();
		return bean.getSlab3rate()*remunits+amount;
		
	}
	public ArrayList<ReadingBean> viewAllBills(String month,String year)
	{
		return new ReadingDao().viewAllBillsByMonth(month,year);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		     
		                  ReadingBean readingBean = new ReadingBean();
		 
		                  readingBean.setAssetId("HO1123");
		                  readingBean.setPresentReading(155);
		                  readingBean.setPastReading(100);
		                  readingBean.setType("mall");
		                  readingBean.setBillMonth("Feb");
		                  readingBean.setBillYear("2015");
		                  String result = new PowerMain().generateBill(readingBean);
		                  System.out.println(result);
		                  ArrayList<ReadingBean>bills=new PowerMain().viewAllBills("Feb","2015");
		                  if(bills!=null){
		                  for(ReadingBean reading: bills){
		                        System.out.println(reading.getSerialNo());
		                        System.out.println(reading.getAmount());
		                  }
		                  
		      }

	}

}
