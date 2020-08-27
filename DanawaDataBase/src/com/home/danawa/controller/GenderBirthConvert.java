package com.home.danawa.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.xml.crypto.Data;

public class GenderBirthConvert {
	
	private int year,month,day,gen;

	public String gnederConvertor(String ssn) {
		
		if(ssn.substring(6,7).equals("1") || ssn.substring(6,7).equals("3")) {		
			return "남";
		} else {
			return "여";
		}		
		
	}
	
	public String birthdayConvertor(String ssn) {
		
		String birth ="";
		
		char gender = ssn.charAt(6);
		year = Integer.parseInt(ssn.substring(0,2));
		month = Integer.parseInt(ssn.substring(2,4));
		day = Integer.parseInt(ssn.substring(4,6));
	
		switch(gender) {
		case '1' :
			year += 1900;
			break;
		case '2' :
			year += 1900;
			break;
		case '3' :
			year += 2000;
			break;
		case '4' :
			year += 2000;
			break;		
		}
		
		birth = year+"/"+ month+"/"+day;
					
	    return birth;
	
	}
}
