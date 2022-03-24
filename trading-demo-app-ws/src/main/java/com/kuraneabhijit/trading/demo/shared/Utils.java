package com.kuraneabhijit.trading.demo.shared;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Utils {
	private final Random random=new SecureRandom();
	private final String ALPHABETS="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	
	
	public String generateUserId()
	{
		return generateRandomString(30);
	}
	
	private String generateRandomString(int length)
	{
		StringBuilder stringBuilder=new StringBuilder(length);
		
		for(int i=0;i<length;i++)
		{
			stringBuilder.append(ALPHABETS.charAt(random.nextInt(ALPHABETS.length())));
			
		}
		
		return stringBuilder.toString();
	}

}

