package com.wipro.hms.service;

import java.util.ArrayList;
import java.util.List;
import com.wipro.hms.bean.RentalPropertyBean;
import com.wipro.hms.util.InvaildCityException;
import com.wipro.hms.dao.*;

public class RentalPropertyService {
	public String addRentalProperty(RentalPropertyBean bean)
	{
		if(bean.getCity()==null||bean.getLocation()==null)
		{
			return("NULL VALUES IN INPUT");
		}
		if(bean.getCity().length()==0||bean.getLocation().length()==0||bean.getNumbedrooms()<=0||bean.getRentalAmount()<=0)
		{
			return("INVALID INPUT");
			
		}
		try{
			validateString(bean.getCity());
		}
		catch(InvaildCityException e)
		{
			return(e.toString());
		}
		RentalPropertyObject rj = new RentalPropertyObject();
		int val = rj.createRentalProperty(bean);
		if(val<=0)
			return "FAILURE";
		else
			return "SUCCESS";
		
		
		
	}
	
	public void validateString(String city) throws InvaildCityException
	{
		city = city.toUpperCase();
		if(!(city.equals("CHENNAI") || city.equals("BENGALURU")))
		{
			throw new InvaildCityException();
		}
	}
	
	public List<RentalPropertyBean> getPropertyByCriteria(float minRentalAmount,float maxRentalAmount,int noOfBedRooms,String location,String city)
	{
		List<RentalPropertyBean>  result= new ArrayList<RentalPropertyBean>();
		RentalPropertyBean rbean = new RentalPropertyBean();
		rbean.setCity(city);
		rbean.setLocation(location);
		rbean.setNumbedrooms(noOfBedRooms);
		RentalPropertyObject ro = new RentalPropertyObject(); 
		result = ro.findPropertyByCriteria(minRentalAmount, maxRentalAmount, rbean);
		return result;
	}
	public String fetchRentalProperty(float minRentalAmount,float maxRentalAmount,int noOfBedRooms,String location,String city)
	{
		if(minRentalAmount<=0||maxRentalAmount<=0||noOfBedRooms<=0|| minRentalAmount>maxRentalAmount||city==null||location==null)
		{
			return "INVALID INPUT";
		}
		try{
			validateString(city);
		}
		catch(InvaildCityException e)
		{
			return e.toString();
		}
		List<RentalPropertyBean> lbean = this.getPropertyByCriteria(minRentalAmount, maxRentalAmount, noOfBedRooms, location, city);
		int size = lbean.size();
		if(size==0)
		{
			return "NO MATCHING RECORDS";
		}
		return "MATCHING RECORDS:"+String.valueOf(size); 
	}


	public static void main(String[] args) {
		
		String result=new RentalPropertyService().fetchRentalProperty(3000,5000,2,"adayar","chennai");
		System.out.println(result);
		}


}
