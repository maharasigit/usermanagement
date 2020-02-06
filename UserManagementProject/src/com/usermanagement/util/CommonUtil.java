package com.usermanagement.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CommonUtil {
public static String convertObjectToJson(Object object){
	
	ObjectMapper objectMapper = new ObjectMapper();
	String jsonString="";
	try {
		jsonString=objectMapper.writeValueAsString(object);
	} catch (JsonProcessingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return jsonString;
	
}
}
