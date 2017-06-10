package com.wipro.candidate.service;

import java.util.ArrayList;
import java.util.Iterator;

import com.wipro.candidate.bean.CandidateBean;
import com.wipro.candidate.dao.CandidateDao;
import com.wipro.candidate.util.WrongDataException;

public class CandidateMain {
	
	public String addCandidate(CandidateBean bean) throws WrongDataException{
		try{
		if(bean==null||bean.getName()==""||bean.getName().length()<2||bean.getM1()<0||bean.getM1()>100||bean.getM2()<0||bean.getM2()>100||bean.getM3()<0||bean.getM3()>100){
			throw new WrongDataException();
		}
		}
		catch(WrongDataException e)
		{
			return "DATA INCORRECT";
		}
		CandidateDao dao = new CandidateDao();
		String id=dao.generateCandidateId(bean.getName());
		bean.setId(id);
		int total = bean.getM1()+bean.getM1()+bean.getM3();
		if(total>=240)
		{
			bean.setResult("PASS");
			bean.setGrade("DISTINCTION");
		}
		else if(total>=180)
		{
			bean.setGrade("FIRST CLASS");
			bean.setResult("PASS");
		}
		else if(total>=150){
			bean.setGrade("SECOND CLASS");
			bean.setResult("PASS");
		}
		else if(total>=105)
		{
			bean.setGrade("THIRD CLASS");
			bean.setResult("PASS");
		}
		else{
			bean.setGrade("NO GRADE");
			bean.setResult("FAIL");
		}
		dao.addCandidate(bean);
		String result;
		if(total>=105)
			result = "PASS";
		else
			result = "FAIL";
		return id+":"+result;
		
	}
	
	
	public ArrayList<CandidateBean> displayAll(String criteria)
	{
		ArrayList<CandidateBean> res = new ArrayList<CandidateBean>();
		if(criteria.equals("PASS")||criteria.equals("FAIL")||criteria.equals("ALL"))
		{
			CandidateDao dao = new CandidateDao();
			res = dao.getByResult(criteria);
		}
		else
		{
			try{
			throw new WrongDataException();
			}
			catch(WrongDataException e)
			{
				return null;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CandidateMain candidateMain = new CandidateMain();
		String result ="";
		try {
			/*CandidateBean bean = new CandidateBean();
			bean.setName("leo");
			bean.setM1(75);
			bean.setM2(75);
			bean.setM2(75);
			result = candidateMain.addCandidate(bean);*/
			ArrayList<CandidateBean> al = candidateMain.displayAll("");
			Iterator<CandidateBean> i =al.iterator();
			while(i.hasNext())
			{
				CandidateBean bean = i.next();
				System.out.println(bean.getId()+" "+bean.getName()+" "+bean.getResult()+" "+bean.getGrade());
				
			}
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			System.out.println("wrong value select ALL/PASS/FAIL");
		}
		System.out.println(result);

	}

}
