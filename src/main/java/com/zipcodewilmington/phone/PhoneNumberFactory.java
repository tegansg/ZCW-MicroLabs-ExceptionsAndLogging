package com.zipcodewilmington.phone;

import com.zipcodewilmington.exceptions.InvalidPhoneNumberFormatException;

import java.util.Random;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/**
 * Created by leon on 5/1/17.
 */
public final class PhoneNumberFactory {
    private static final Logger logger = Logger.getGlobal();

    private PhoneNumberFactory() {
        /** This constructor is private
         *  This class is uninstantiable */
    }

    /**
     * @param phoneNumberCount - number of PhoneNumber objects to instantiate
     * @return array of randomly generated PhoneNumber objects
     */ //TODO - Implement logic
    public static PhoneNumber[] createRandomPhoneNumberArray(int phoneNumberCount) {
    	
    	PhoneNumber[] numberArray = new PhoneNumber[phoneNumberCount];
    	for(int i=0; i<phoneNumberCount; i++)
    	{
    		numberArray[i] = createRandomPhoneNumber();
    	}
    	return numberArray;
    }

    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */ //TODO - Implement logic
    private static PhoneNumber createRandomPhoneNumber() 
    {
        Random random = new Random();
    	int a = random.nextInt(900)+100;
    	int b = random.nextInt(900)+100;
    	int c = random.nextInt(9000)+1000;
    	
    	return createPhoneNumberSafely(a, b, c);
    }


    /**
     * @param areaCode          - 3 digit code
     * @param centralOfficeCode - 3 digit code
     * @param phoneLineCode     - 4 digit code
     * @return a new phone number object
     */ //TODO - if input is valid, return respective PhoneNumber object, else return null
    public static PhoneNumber createPhoneNumberSafely(int areaCode, int centralOfficeCode, int phoneLineCode) {
    	String numberString = String.format("(%d)-%d-%d", areaCode, centralOfficeCode, phoneLineCode);
    	try
    	{
    		return createPhoneNumber(numberString);
    	}
    	catch(InvalidPhoneNumberFormatException exc)
    	{
        	String message = String.format("%s is not a valid phone number", numberString);
        	LogRecord record = new LogRecord(Level.WARNING, message);
        	logger.log(record);
    		return null;
    	}
    	
    }

    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */ // TODO - Add throws statement to method signature
    public static PhoneNumber createPhoneNumber(String phoneNumberString) throws InvalidPhoneNumberFormatException 
    {
    	String message = String.format("Attempting to create a new phone number object with the value of %s", phoneNumberString);
    	LogRecord record = new LogRecord(Level.INFO, message);
    	logger.log(record);
    	return new PhoneNumber(phoneNumberString);
    	
  
    	
   
    }
}
