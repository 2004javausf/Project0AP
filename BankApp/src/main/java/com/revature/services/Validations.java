package com.revature.services;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.ParseException; 


public class Validations {
	
	public boolean validateInteger(String s) {
		try {
			Integer.parseInt(s);
			System.out.println(s + " is a valid integer number");
			return true;
		}
		catch(NumberFormatException e){
			System.out.println(s + " is  not a valid integer number");
			return false;
		}
			
	}
	
	public boolean validateDouble(String s) {
		try {
			Double.parseDouble(s);
			System.out.println(s + " is a valid double number");
			return true;
		}
		catch(NumberFormatException e){
			System.out.println(s + " is  not a valid double number");	
			return false;
		}
			
	}
	
	public boolean validateLong(String s) {
		try {
			Long.parseLong(s);
			System.out.println(s + " is a valid long number");
			return true;
		}
		catch(NumberFormatException e){
			System.out.println(s + " is  not a valid long number");	
			return false;
		}
			
	}
	
	public boolean validateDate(String strDate) {	
		// Check if date is 'null'
		if (strDate.trim().equals("")){
		    return true;
		}
		// Date is not 'null'
		else{ //Set preferred date format 
		    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		    sdf.setLenient(false);
		    try{
		        Date date = sdf.parse(strDate); 
		
		    }
		    /* Date format is invalid */
		    catch (ParseException e)
		    {
		        System.out.println("Invalid Date. Try again");
		        return false;
		    }
		    /* Return true if date format is valid */
		    return true;
		}
	   }
	
	public boolean validateEmail(String email) { 
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) {
        	System.out.println("There is no email");
            return false; 
        }
        System.out.println(pat.matcher(email).matches());
        return pat.matcher(email).matches(); 
    } 
	
	public boolean validateGender(String s) {
		if((s.equalsIgnoreCase("M")) || (s.equalsIgnoreCase("F"))){
			return true;
		}
		else {
			System.out.println("Invalid Input. Try Again");
			return false;
		}
	}
	
	public boolean validatePhone(CharSequence l) {
		Pattern pattern = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");
		Pattern anotherPattern = Pattern.compile("\\d{10}"); 
		Matcher matcher = pattern.matcher(l);
		Matcher anotherMatcher = anotherPattern.matcher(l);
		if(matcher.matches() || anotherMatcher.matches()) {
			return true;	
		}
		else {
			System.out.println("Invalid Entry");
			return false;
		}
		
	}
	

	
	

}
