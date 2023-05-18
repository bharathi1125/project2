package com.project;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FlightBooking {

	
		
@Test
	public static void createFlight() {
	RequestSpecification reqSpec;
	reqSpec = RestAssured.given();
	reqSpec = reqSpec.header("Content-Type", "application/json");
	reqSpec=reqSpec.body("{\r\n" + 
			"    \"flightName\": \"AirIndia\",\r\n" + 
			"    \"Country\": \"India\",\r\n" + 
			"    \"Destinations\": \"87\",\r\n" + 
			"    \"URL\": \"https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India\"\r\n" + 
			"}");
	Response response = reqSpec.get("https://www.omrbranch.com/api/flights");
	int statusCode = response.getStatusCode();
	System.out.println(statusCode);
	
     JsonPath path = response.jsonPath();
      Object value = path.get("data[0].id");

//	String id=(String) value;
      System.out.println(value);
//      Assert.assertEquals("3,id", "verify id");
	
//      String asString = response.asString();
//	System.out.println(asString);

	String asPrettyString = response.asPrettyString();
	System.out.println(asPrettyString);

		
	}

}
