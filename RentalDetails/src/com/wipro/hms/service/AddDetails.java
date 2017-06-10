package com.wipro.hms.service;

import java.util.Scanner;

import com.wipro.hms.bean.RentalPropertyBean;
import com.wipro.hms.dao.RentalPropertyObject;

public class AddDetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("please enter the details of the rental property");
		RentalPropertyBean bean = new RentalPropertyBean();
		System.out.println("enter city");
		String city = sc.nextLine();
		bean.setCity(city);
		System.out.println("enter location");
		String location = sc.nextLine();
		bean.setLocation(location);
		System.out.println("enter number of bed rooms");
		int numBedRooms = sc.nextInt();
		bean.setNumbedrooms(numBedRooms);
		System.out.println("enter rent");
		float rentalAmount = sc.nextFloat();
		bean.setRentalAmount(rentalAmount);
		RentalPropertyObject r1 = new RentalPropertyObject();
		r1.createRentalProperty(bean);
		sc.close();
	}

}
